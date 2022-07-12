package com.example.moviereviewsystem.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "studio")
public class Studio {

    @Id
    @Column(name = "studio_id", nullable = false)
    private Long studioId;

    @Column(name = "studio_name", nullable = false)
    private String studioName;

    @Column(name = "studio_location", nullable = false)
    private String studioLocation;

	public Studio() {

	}

	public Studio(Long studioId, String studioName, String studioLocation) {
		super();
		this.studioId = studioId;
		this.studioName = studioName;
		this.studioLocation = studioLocation;
	}

	@Override
	public String toString() {
		return "Studio [studioId=" + studioId + ", studioName=" + studioName + ", studioLocation=" + studioLocation
				+ "]";
	}

	public Long getStudioId() {
		return studioId;
	}

	public void setStudioId(Long studioId) {
		this.studioId = studioId;
	}

	public String getStudioName() {
		return studioName;
	}

	public void setStudioName(String studioName) {
		this.studioName = studioName;
	}

	public String getStudioLocation() {
		return studioLocation;
	}

	public void setStudioLocation(String studioLocation) {
		this.studioLocation = studioLocation;
	}
    
    
}
