package ms.dto;

/**
 * @author nishch
 * @version 1.0
 * @date 2020/6/8
 * @des
 */
public class SupportEntity {

    private String name;
    private String detail;
    private String code;

    public SupportEntity(String name, String detail, String code) {
        this.name = name;
        this.detail = detail;
        this.code = code;
    }

    public SupportEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
