package com.desafio.zup.model;

import com.desafio.zup.dto.ComicItemDTO;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class ComicModel {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column
    private String title;

    @Column(length = 500)
    private String description;
    @Column
    private String isbn;

    @Column
    private double price;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "comic_id")
    private List<CreatorModel> creators;

    @OneToOne
    private UserModel user;

    @Enumerated(EnumType.ORDINAL)
    private WeekDay discountDay;

    @Transient
    private boolean discountActive;

    public ComicModel() {
        this.setDiscountDay(WeekDay.FRIDAY);
    }

    public WeekDay getDiscountDay() {
        return discountDay;
    }

    public void setDiscountDay(WeekDay discountDay) {
        this.discountDay = discountDay;
    }

    public boolean isDiscountActive() {
        return discountActive;
    }

    public void setDiscountActive(boolean discountActive) {
        this.discountActive = discountActive;
    }

    @PostLoad
    @PostPersist
    private void calculateDiscount(){
        LocalDate date = LocalDate.now();
        this.discountActive = date.getDayOfWeek().toString().equals(this.discountDay.toString());
        if (this.discountActive){
            this.price = this.price - this.price * 10 /100;
        }
    }

    public void toComicModel(ComicItemDTO comicItem) {
        this.setCreators(comicItem.getCreators().getItems().stream().map(item -> {
            CreatorModel creatorModel = new CreatorModel();
            creatorModel.toCreator(item);
            return creatorModel;
        }).collect(Collectors.toList()));
        this.setIsbn(comicItem.getIsbn());
        this.setDescription(comicItem.getDescription());
        this.setTitle(comicItem.getTitle());
        this.setPrice(comicItem.getPrices().get(0).getPrice());
        this.selectDiscountDay(comicItem.getIsbn());
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
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

    public String getIsbn() {
        return isbn;
    }

    private void selectDiscountDay(String isbn) {
        WeekDay selectedDay;
        int lastNumberIsbn = Integer.parseInt(isbn.substring(isbn.length() - 1));
        this.isbn = isbn;
        switch (lastNumberIsbn) {
            case 0:
            case 1: {
                selectedDay = WeekDay.MONDAY;
                break;
            }
            case 2:
            case 3: {
                selectedDay = WeekDay.TUESDAY;
                break;
            }
            case 4:
            case 5: {
                selectedDay = WeekDay.WEDNESDAY;
                break;
            }
            case 6:
            case 7: {
                selectedDay = WeekDay.THURSDAY;
                break;
            }
            default:
                selectedDay = WeekDay.FRIDAY;
                break;
        }
        this.setDiscountDay(selectedDay);
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<CreatorModel> getCreators() {
        return creators;
    }

    public void setCreators(List<CreatorModel> creators) {
        this.creators = creators;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ComicModel(Long id, String title, String description, String isbn, double price, List<CreatorModel> creators) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isbn = isbn;
        this.price = price;
        this.creators = creators;
    }


}
