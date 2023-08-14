package basic.practise;

/**
 * Computer 类
 *
 */
public class Computer {

    /**
     *  cpu 属性
     */
    private String cpu;

    /**
     * 内存 属性
     */
    private int memory;

    /**
     * 磁盘 属性
     */
    private int disk;

    public Computer(String cpu, int memory, int disk) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }

    // 返回 Computer 信息
    public String getDetails() {
        return "cpu=" + cpu + " memory=" + memory + " disk=" + disk;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getDisk() {
        return disk;
    }

    public void setDisk(int disk) {
        this.disk = disk;
    }
}
