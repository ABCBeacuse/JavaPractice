package basic.practise.renthouse.service;

import basic.practise.renthouse.domain.House;

public class HouseService {

    /**
     * 存储房屋信息的数组
     */
    private House[] houses;

    /**
     * 当前房屋记录数量
     */
    private int num = 1;

    /**
     * 房屋起始 id
     */
    private int houseId = 1;

    public HouseService(int size) {
        houses = new House[size];
        houses[0] = new House(houseId, "一号房子", "12432432", "海淀区", 1000, "未出租");
    }

    /**
     * 获取房屋列表信息
     *
     * @return
     */
    public House[] list() {
        return houses;
    }

    /**
     * 新增房屋信息
     *
     * @param house
     * @return
     */
    public boolean add(House house) {
        // todo 暂时先不考虑数组扩容
        if (num == houses.length) {
            System.out.println("当前房屋记录已满....");
            return false;
        }
        // 房屋的 id 自增
        house.setId(++houseId);
        houses[num++] = house;
        return true;
    }

    /**
     * 删除对应 id 的房屋信息
     *
     * @param id
     * @return
     */
    public boolean delete(int id) {
        int search = search(id);
        if (search != -1) {
            // 数组中记录信息整体往前移动，-1 考虑到了数组满的情况，eg：当 num = 10 时，如果是 i < num，i 最大能到 9。i+1 就会出现 NLP。所以 -1 。
            for (int i = search; i < num - 1; i++) {
                houses[i] = houses[i + 1];
            }
            // 把当前房屋信息的的最后一个置为 Null
            houses[--num] = null;
            return true;
        }
        return false;
    }

    /**
     * 查看传入的房屋编号 id 所在下标，不存在则返回 -1。
     *
     * @param id
     * @return
     */
    public int search(int id) {
        for (int i = 0; i < num; i++) {
            if (houses[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public House searchHouse(int id) {
        for (House house : houses) {
            if (house == null) {
                break;
            }
            if (house.getId() == id) {
                return house;
            }
        }
        return null;
    }
}
