package cos.bind;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

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
        System.out.println(".......走init方法----");
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        System.out.println(".......走process方法----");

        Set<? extends Element> rootElements = roundEnvironment.getRootElements();
        Set<TypeElement> typeElementsToProcess = ProcessingUtils.getTypeElementsToProcess(rootElements, set);
        for (Element element :
                typeElementsToProcess) {
            System.out.println("包名：" + elementUtils.getPackageOf(element).getQualifiedName());
        }


        return true;
    }


    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return super.getSupportedAnnotationTypes();

//        return new TreeSet<>(Arrays.asList(InjectView.class.getCanonicalName()));
    }
}
