package cos.jingzheng.gittestwidget.progressBar;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by jingzheng on 2018/6/17.
 */


public class CardAnswerBean {
    @Setter
    @Getter
    public int i1;
    @Setter
    public int[] ints;//回答的
    @Setter
    public int[] ints1;//所有的
    List<Answer> answers = new ArrayList<>();

    public List<Answer> getAnswers() {
        if (ints.length > 0 && ints.length == ints1.length) {
            answers.clear();
            char c = 'A';
            for (int i = 0; i < ints.length; i++) {
                char resl = (char) (c + i);
                answers.add(new Answer(ints[i], ints1[i], resl));
            }
        }
        return answers;
    }

    class Answer {
        int answered;
        int all;
        char letter;

        public Answer(int answered, int all, char letter) {
            this.answered = answered;
            this.all = all;
            this.letter = letter;
        }
    }
}
