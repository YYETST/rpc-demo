package ms.dto;

/**
 * @author nishch
 * @version 1.0
 * @date 2020/6/8
 * @des
 */
public class ItemEntity {

    private String name;
    private String code;

    public ItemEntity(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public ItemEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
