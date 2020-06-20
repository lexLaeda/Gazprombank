package com.test.yourself.model;

import java.util.ArrayList;
import java.util.List;


public class Post extends AbstractEntity{

    private String title;
    private String text;
    private String image;
    private List<Comment> comments = new ArrayList<>();
    private Long plusAmount;
    private Long minusAmount;

}
