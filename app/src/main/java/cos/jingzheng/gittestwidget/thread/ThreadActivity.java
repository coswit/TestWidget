package cos.jingzheng.gittestwidget.thread;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cos.jingzheng.gittestwidget.R;

public class ThreadActivity extends AppCompatActivity {

    public static final String TAG = "tag_thread";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn)
    public void onViewClicked() {
        start();
    }

    private void start(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<>(task);
        executorService.execute(futureTask);
//        executorService.submit(futureTask);
        executorService.shutdown();

        Log.d(TAG, "start: 主线程");
        Integer i = 0;
        try {
            i = futureTask.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d(TAG,i.toString());
    }


    class Task implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            Log.d(TAG, "call: 子线程");
            Thread.sleep(3000);
            int result = 0;
            for(int i = 0;i<300;i++) {
                result+=i;
            }
            return result;
        }
    }
}
