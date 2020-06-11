package ms.dto;

import java.io.Serializable;

public class TourOrder implements Serializable {
	private static final long serialVersionUID = 3473624866773569315L;
	private Long id;
	private String orderName;
	private String userId;
	private String userName;
	private String dest;
	private String status;
	private String tourOrderId;

	public String getDest() {
		return this.dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderName() {
		return this.orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTourOrderId() {
		return this.tourOrderId;
	}

	public void setTourOrderId(String tourOrderId) {
		this.tourOrderId = tourOrderId;
	}

	public TourOrder() {
	}

	public TourOrder(Long id, String orderName, String userId, String userName,
                     String dest, String status, String tourOrderId) {
		this.id = id;
		this.orderName = orderName;
		this.userId = userId;
		this.userName = userName;
		this.dest = dest;
		this.status = status;
		this.tourOrderId = tourOrderId;
	}
}
