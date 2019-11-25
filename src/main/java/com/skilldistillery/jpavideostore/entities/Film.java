package com.skilldistillery.jpavideostore.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    @Column(name = "release_year")
    private int releaseYear;
    @Column(name = "rental_rate")
    private double rentalRate;
    private int length;
    @Column(name = "replacement_cost")
    private double replacementCost;
    @Enumerated(EnumType.STRING)
    private Rating rating;
    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;
    @ManyToMany(mappedBy = "films")
    private List<Actor> actors;
    @ManyToMany(mappedBy = "films")
    private List<Category> categories;
    @ManyToMany(mappedBy = "films")
    private List<Store> stores;
    
    @OneToMany(mappedBy = "film")
    private List<InventoryItem> copies;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
    public double getRentalRate() {
        return rentalRate;
    }
    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public double getReplacementCost() {
        return replacementCost;
    }
    public void setReplacementCost(double replacementCost) {
        this.replacementCost = replacementCost;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Film [id=").append(id).append(", title=").append(title).append(", description=")
                .append(description).append(", releaseYear=").append(releaseYear).append(", rentalRate=")
                .append(rentalRate).append(", length=").append(length).append(", replacementCost=")
                .append(replacementCost).append(", rating=").append(rating).append(", language=").append(language)
                .append("]");
        return builder.toString();
    }
    public Rating getRating() {
        return rating;
    }
    public void setRating(Rating rating) {
        this.rating = rating;
    }
    public Language getLanguage() {
        return language;
    }
    public void setLanguage(Language language) {
        this.language = language;
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
        Film other = (Film) obj;
        if (id != other.id)
            return false;
        return true;
    }
    public List<Actor> getActors() {
        return actors;
    }
    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
    
    public List<Category> getCategories() {
        return categories;
    }
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
    public void addCategory(Category cat) {
        if (categories == null) {
            categories = new ArrayList<>();
        }
        if (!categories.contains(cat)) {
            categories.add(cat);
            cat.addFilm(this);
        }
    }
    public void removeCategory(Category cat) {
        if (categories != null && categories.contains(cat)) {
            categories.remove(cat);
            cat.removeFilm(this);
        }
    }
    public List<Store> getStores() {
        return stores;
    }
    public void setStores(List<Store> stores) {
        this.stores = stores;
    }
    public List<InventoryItem> getCopies() {
        return copies;
    }
    public void setCopies(List<InventoryItem> copies) {
        this.copies = copies;
    }
    
 // must add / rm on both sides of M:M (film<->actor)
    public void addActor (Actor actor) {
        if (actors == null) actors = new ArrayList<>();
        if (!actors.contains(actor)) {
            actors.add(actor);
            actor.addFilm(this);
        }
    }
    
    public void removeActor(Actor actor) {
        if(actors != null && actors.contains(actor)) {
            actors.remove(actor);
            actor.removeFilm(this);
        }
    }

//    public void addActor(Actor actor) {
//        if (actors == null) {
//            actors = new ArrayList<>();
//        }
//        if (!actors.contains(actor)) {
//            actors.add(actor);
//            actor.addFilm(this);
//        }
//    }
//    public void removeActor(Actor actor) {
//        if (actors != null && actors.contains(actor)) {
//            actors.remove(actor);
//            actor.removeFilm(this);
//        }
//    }




}
//import java.util.ArrayList;
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
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
//
//@Entity
//public class Film {
//
//	 	 	
//		
//		@Id
//		@GeneratedValue(strategy = GenerationType.IDENTITY)
//		private int id;
//		
//		public void addCategory(Category category) {
//			if(categories == null) categories = new ArrayList<>();
//			
//			if(!categories.contains(category)) {
//				categories.add(category);
//				category.addFilm(this);
//			}
//		}
//		public void removeCategory(Category category) {
//			if(categories != null && categories.contains(category)) {
//				categories.remove(category);
//				category.removeFilm(this);
//			}
//		}
//		@ManyToOne
//		@JoinColumn(name="id")
//		private InventoryItem item;
//		
//		@ManyToMany(mappedBy="films")
//		  private List<Category> categories;
//		
//		@ManyToMany(mappedBy="films")
//		  private List<Store> stores;
////		@ManyToMany(mappedBy="films", fetch=FetchType.LAZY);
////		private List<Actor> actors;
//		
//		@ManyToMany(mappedBy="name")
//		private String name;
//		
//		
//		private String title;
//		private String description;
//		
//		@Column
//		private Integer releaseYear;
//		
//		@Column
//		private Double rentalRate;
//		
//		private Integer length;
//		@Column
//		private Double replacementCost;
//		
//		@Enumerated(EnumType.STRING)
//		private Rating rating;
//		
//		@ManyToOne
//		@JoinColumn(name="language_id")
//		private Language language;
//		
//		public Rating getRating() {
//			return rating;
//		}
//		public void setRating(Rating rating) {
//			this.rating = rating;
//		}
//		public int getId() {
//			return id;
//		}
//		public void setId(int id) {
//			this.id = id;
//		}
//		public String getTitle() {
//			return title;
//		}
//		public void setTitle(String title) {
//			this.title = title;
//		}
//		public String getDescription() {
//			return description;
//		}
//		public void setDescription(String description) {
//			this.description = description;
//		}
//		public Integer getReleaseYear() {
//			return releaseYear;
//		}
//		public void setReleaseYear(Integer releaseYear) {
//			this.releaseYear = releaseYear;
//		}
//		public Double getRentalRate() {
//			return rentalRate;
//		}
//		public void setRentalRate(Double rentalRate) {
//			this.rentalRate = rentalRate;
//		}
//		public Integer getLength() {
//			return length;
//		}
//		public void setLength(Integer length) {
//			this.length = length;
//		}
//		public Double getReplacementCost() {
//			return replacementCost;
//		}
//		public void setReplacementCost(Double replacementCost) {
//			this.replacementCost = replacementCost;
//		}
//		@Override
//		public int hashCode() {
//			final int prime = 31;
//			int result = 1;
//			result = prime * result + ((description == null) ? 0 : description.hashCode());
//			result = prime * result + id;
//			result = prime * result + ((length == null) ? 0 : length.hashCode());
//			result = prime * result + ((rating == null) ? 0 : rating.hashCode());
//			result = prime * result + ((releaseYear == null) ? 0 : releaseYear.hashCode());
//			result = prime * result + ((rentalRate == null) ? 0 : rentalRate.hashCode());
//			result = prime * result + ((replacementCost == null) ? 0 : replacementCost.hashCode());
//			result = prime * result + ((title == null) ? 0 : title.hashCode());
//			return result;
//		}
//		@Override
//		public boolean equals(Object obj) {
//			if (this == obj)
//				return true;
//			if (obj == null)
//				return false;
//			if (getClass() != obj.getClass())
//				return false;
//			Film other = (Film) obj;
//			if (description == null) {
//				if (other.description != null)
//					return false;
//			} else if (!description.equals(other.description))
//				return false;
//			if (id != other.id)
//				return false;
//			if (length == null) {
//				if (other.length != null)
//					return false;
//			} else if (!length.equals(other.length))
//				return false;
//			if (rating != other.rating)
//				return false;
//			if (releaseYear == null) {
//				if (other.releaseYear != null)
//					return false;
//			} else if (!releaseYear.equals(other.releaseYear))
//				return false;
//			if (rentalRate == null) {
//				if (other.rentalRate != null)
//					return false;
//			} else if (!rentalRate.equals(other.rentalRate))
//				return false;
//			if (replacementCost == null) {
//				if (other.replacementCost != null)
//					return false;
//			} else if (!replacementCost.equals(other.replacementCost))
//				return false;
//			if (title == null) {
//				if (other.title != null)
//					return false;
//			} else if (!title.equals(other.title))
//				return false;
//			return true;
//		}
//		@Override
//		public String toString() {
//			return "Film [id=" + id + ", title=" + title + ", description=" + description + ", releaseYear="
//					+ releaseYear + ", rentalRate=" + rentalRate + ", length=" + length + ", replacementCost="
//					+ replacementCost + ", rating=" + rating + "]";
//		}
//		public Film() {
//			super();
//		}
//		public Language getLanguage() {
//			return language;
//		}
//		public void setLanguage(Language language) {
//			this.language = language;
//		}
//		public InventoryItem getItem() {
//			return item;
//		}
//		public void setItem(InventoryItem item) {
//			this.item = item;
//		}
//		public List<Category> getCategories() {
//			return categories;
//		}
//		public void setCategories(List<Category> categories) {
//			this.categories = categories;
//		}
//		public List<Store> getStores() {
//			return stores;
//		}
//		public void setStores(List<Store> stores) {
//			this.stores = stores;
//		}
//		public String getName() {
//			return name;
//		}
//		public void setName(String name) {
//			this.name = name;
//		}
//	
//}
