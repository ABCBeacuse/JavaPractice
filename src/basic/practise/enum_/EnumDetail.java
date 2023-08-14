package basic.practise.enum_;

public class EnumDetail {
    public static void main(String[] args) {
        // 枚举对象，所以能调用 play 方法
        Music.CLASSIC_MUSIC.play(); // 播放古典音乐....
    }
}

interface IPlaying {
    void play();
}

enum Music implements IPlaying {
    CLASSIC_MUSIC;  // public static final Music CLASSIC_MUSIC = new Music();

    @Override
    public void play() {
        System.out.println("播放古典音乐....");
    }
}

