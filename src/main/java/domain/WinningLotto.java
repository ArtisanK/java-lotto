package domain;

import java.util.List;
/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNo;

    public WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Rank match(Lotto userLotto) {
        // TODO 로직 구현
        boolean bonus = bonusMatch(userLotto);
        return Rank.valueOf(getMatch(userLotto), bonus);
    }

    private boolean bonusMatch(Lotto userLotto) {
        return userLotto.getNumbers().contains(bonusNo);
    }

    private int getMatch(Lotto userLotto) {
        List<Integer> user = userLotto.getNumbers();
        List<Integer> master = lotto.getNumbers();
        user.retainAll(master);
        return user.size();
    }

}
