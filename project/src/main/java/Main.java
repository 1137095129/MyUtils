import util.EquipmentUtils;

public class Main {

    public static void main(String[] args) {

        String token = "at.a0xjmmjz618enjo1d2rh1w4qd3izs4h9-2vcof1cese-0isa4pp-igzksxaij";
        EquipmentUtils equipmentUtils = new EquipmentUtils();

        System.out.println(equipmentUtils.getAllLiveList(token,1));

        System.out.println(equipmentUtils.getAllLiveList(token,0));

        System.out.println(equipmentUtils.getEquipmentByDeviceSerial(token,"211660584"));

        System.out.println(equipmentUtils.getLiveAddressBySource(token,"211660584",1));
    }

}
