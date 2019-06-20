package cos.bind;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementFilter;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic;

@SupportedAnnotationTypes({"cos.bind.InjectView"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class CustomProcessor extends AbstractProcessor {


    private Filer filer;
    private Messager messager;
    private Elements elementUtils;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        filer = processingEnvironment.getFiler();
        messager = processingEnvironment.getMessager();
        elementUtils = processingEnvironment.getElementUtils();
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {

        Set<? extends Element> rootElements = roundEnvironment.getRootElements();
        Set<TypeElement> typeElements = ProcessingUtils.getTypeElementsToProcess(rootElements, set);
        for (Element typeElement : typeElements) {
            //包名
            String packageName = elementUtils.getPackageOf(typeElement).getQualifiedName().toString();
            //类名
            String typeName = typeElement.getSimpleName().toString();
            //全路径类名
            ClassName className = ClassName.get(packageName, typeName);
            //生成的类名
            ClassName generatedName = ClassName.get(packageName, NameStore.getGeneratedClassName(typeName));

            TypeSpec.Builder classBuilder = TypeSpec.classBuilder(generatedName)
                    .addModifiers(Modifier.PUBLIC);

            //构造函数
            //public MainActivity$Binding(MainActivity activity) {bindViews(activity);}
            classBuilder.addMethod(MethodSpec.constructorBuilder()
                    .addModifiers(Modifier.PUBLIC)
                    .addParameter(className, NameStore.Variable.ANDROID_ACTIVITY)
                    .addStatement("$N($N)", NameStore.Method.BIND_VIEWS, NameStore.Variable.ANDROID_ACTIVITY)

                    .build());

            //方法构造
            MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder(NameStore.Method.BIND_VIEWS)
                    .addParameter(className, NameStore.Variable.ANDROID_ACTIVITY)
                    .addModifiers(Modifier.PRIVATE)
                    .returns(void.class);

            List<VariableElement> enclosedElements = ElementFilter.fieldsIn(typeElement.getEnclosedElements());
            for (VariableElement variableElement : enclosedElements) {
                InjectView injectView = variableElement.getAnnotation(InjectView.class);
                messager.printMessage(Diagnostic.Kind.NOTE,
                        "注解view："+injectView);
                if (injectView != null) {
                    //activity.tvContent = (TextView)activity.findViewById(2131165322);
                    methodBuilder.addStatement("$N.$N = ($T) $N.findViewById($L)",
                            NameStore.Variable.ANDROID_ACTIVITY,
                            variableElement.getSimpleName(),
                            variableElement,
                            NameStore.Variable.ANDROID_ACTIVITY,
                            injectView.value()
                    );
                }
            }

            classBuilder.addMethod(methodBuilder.build());
            try {
                JavaFile.builder(packageName, classBuilder.build())
                        .build()
                        .writeTo(filer);
            } catch (IOException e) {
                e.printStackTrace();
                messager.printMessage(Diagnostic.Kind.ERROR, e.getMessage());
            }
        }


        return true;
    }


    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return new TreeSet<>(Arrays.asList(
                InjectView.class.getCanonicalName(),
                OnClick.class.getCanonicalName()
        ));
    }
}
