package com.skilldistillery.jpavideostore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inventory_item")
public class InventoryItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "media_condition")
    @Enumerated(EnumType.STRING)
    private MediaCondition mediaCondition;
    
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;
    
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MediaCondition getMediaCondition() {
        return mediaCondition;
    }

    public void setMediaCondition(MediaCondition mediaCondition) {
        this.mediaCondition = mediaCondition;
    }

    public InventoryItem(int id, MediaCondition mediaCondition) {
        super();
        this.id = id;
        this.mediaCondition = mediaCondition;
    }

    public InventoryItem() {
        super();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("InventoryItem [id=").append(id).append(", mediaCondition=").append(mediaCondition)
                .append(", film=").append(film).append(", store=").append(store).append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        InventoryItem other = (InventoryItem) obj;
        if (id != other.id)
            return false;
        return true;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

}
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "inventory_item")
//public class InventoryItem {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//	@Column(name = "media_condition")
//	@Enumerated(EnumType.STRING)
//	private MediaCondition mediaCondition;
//	
//	@ManyToOne
//	@JoinColumn(name="film_id")
//	private Film film;
//	
//	private Store store;
//	
//	private List<Rental> rentals;
//	
//	
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public MediaCondition getMediaCondition() {
//		return mediaCondition;
//	}
//
//	public void setMediaCondition(MediaCondition mediaCondition) {
//		this.mediaCondition = mediaCondition;
//	}
//
//	public InventoryItem(int id, MediaCondition mediaCondition) {
//		super();
//		this.id = id;
//		this.mediaCondition = mediaCondition;
//	}
//
//	public InventoryItem() {
//		super();
//	}
//
//	@Override
//	public String toString() {
//		return "inventoryitem [id=" + id + ", mediaCondition=" + mediaCondition + "]";
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + id;
//		result = prime * result + ((mediaCondition == null) ? 0 : mediaCondition.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		InventoryItem other = (InventoryItem) obj;
//		if (id != other.id)
//			return false;
//		if (mediaCondition != other.mediaCondition)
//			return false;
//		return true;
//	}
//
//	public Film getFilm() {
//		return film;
//	}
//
//	public void setFilm(Film film) {
//		this.film = film;
//	}
//
//	public Store getStore() {
//		return store;
//	}
//
//	public void setStore(Store store) {
//		this.store = store;
//	}
//
//}
