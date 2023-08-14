package basic.practise.renthouse.view;

import basic.practise.renthouse.domain.House;
import basic.practise.renthouse.service.HouseService;
import basic.practise.utils.Utility;

public class HouseView {

    private boolean loop = true;

    private char key;

    /**
     * 初始化 10 个大小的房子数组
     */
    private HouseService houseService = new HouseService(10);

    public void mainMenu() {
        do {
            System.out.println("======房屋出租系统======");
            System.out.println("======1. 新增房源 ======");
            System.out.println("======2. 查找房屋 ======");
            System.out.println("======3. 删除房屋 ======");
            System.out.println("======4. 修改房屋信息 ======");
            System.out.println("======5. 房屋列表 ======");
            System.out.println("======6. 退   出 ======");
            System.out.println("====== 请输入你的选择 ======");
            key = Utility.readChar();
            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    getHouseDetailById();
                    break;
                case '3':
                    deleteHouse();
                    break;
                case '4':
                    System.out.println("修改");
                    break;
                case '5':
                    listHouses();
                    break;
                case '6':
                    loop = false;
            }
        } while (loop);
    }

    /**
     * 房屋列表显示
     */
    private void listHouses() {
        System.out.println("======房屋列表======");
        System.out.println("编号\t房主\t电话\t地址\t月租\t状态(未出租/已出租)");
        House[] houses = houseService.list();
        for (House house : houses) {
            if (house == null) {
                break;
            }
            System.out.println(house);
        }
    }

    /**
     * 添加新房屋
     */
    private void addHouse() {
        System.out.println("======新增房屋======");
        System.out.print("请输入房主:");
        String name = Utility.readString(10);
        System.out.print("请输入电话");
        String phone = Utility.readString(10);
        System.out.print("请输入地址");
        String address = Utility.readString(10);
        System.out.print("请输入月租");
        int rent = Utility.readInt();
        System.out.print("请输入当前房屋状态");
        String status = Utility.readString(10);

        House newHouse = new House(0, name, phone, address, rent, status);
        boolean result = houseService.add(newHouse);
        if (result) {
            System.out.println("房屋添加成功");
        }
    }

    /**
     * 删除房屋信息
     */
    private void deleteHouse() {
        System.out.println("======删除房屋======");
        System.out.print("请选择待删除房屋编号(-1退出)：");
        int id = Utility.readInt();
        if (id == -1) {
            return;
        }
        // 该方法本身就有循环判断的逻辑，必须输入 Y/N
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {
            boolean result = houseService.delete(id);
            if (result) {
                System.out.println("删除房屋信息成功");
            } else {
                System.out.println("删除房屋信息失败");
            }
        }
    }

    /**
     * 根据房屋 id 查询房屋信息
     */
    private void getHouseDetailById() {
        System.out.print("请输入房屋编号：");
        int id = Utility.readInt();
        House house = houseService.searchHouse(id);
        if(house == null){
            System.out.println("房屋未找到");
            return;
        }
        System.out.println(house);
    }
}
