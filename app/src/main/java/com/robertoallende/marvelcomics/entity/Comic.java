package com.robertoallende.marvelcomics.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Comic implements Serializable  {

    public Integer id; // The unique ID of the comic resource.,
    public Integer digitalId; // The ID of the digital comic representation of this comic. Will be 0 if the comic is not available digitally.,
    public String title; // The canonical title of the comic.,
    public Double issueNumber; // The number of the issue in the series (will generally be 0 for collection formats).,
    public String variantDescription; // If the issue is a variant (e.g. an alternate cover, second printing, or director’s cut), a text description of the variant.,
    public String description; // The preferred description of the comic.,
    public Date modified; // The date the resource was most recently modified.,
    public String isbn; // The ISBN for the comic (generally only populated for collection formats).,
    public String upc; // The UPC barcode number for the comic (generally only populated for periodical formats).,
    public String diamondCode; // The Diamond code for the comic.,
    public String ean; // The EAN barcode for the comic.,
    public String issn; // The ISSN barcode for the comic.,
    public String format; // The publication format of the comic e.g. comic, hardcover, trade paperback.,
    public Integer pageCount; // The number of story pages in the comic.,
    public List<TextObject> textObjects; // A set of descriptive text blurbs for the comic.,
    public String resourceURI; // The canonical URL identifier for this resource.,
    public List<Url> urls; // A set of public web site URLs for the resource.,
    public SeriesSummary series; //  A summary representation of the series to which this comic belongs.,
    public List<ComicSummary> variants; //  A list of variant issues for this comic (includes the "original" issue if the current issue is a variant).,
    public List<ComicSummary> collections; //   A list of collections which include this comic (will generally be empty if the comic's format is a collection).,
    public List<ComicSummary> collectedIssues;  // A list of issues collected in this comic (will generally be empty for periodical formats such as "comic" or "magazine").,
    public List<ComicDate> dates; // A list of key dates for this comic.,
    public List<ComicPrice> prices; // (Array[ComicPrice], optional): A list of prices for this comic.,
    public Image thumbnail; // The representative image for this comic.,
    public List<Image> images; // A list of promotional images associated with this comic.,
    public CreatorList creators;  //  A resource list containing the creators associated with this comic.,
    public CharacterList characters; // A resource list containing the characters which appear in this comic.,
    public StoryList stories; // A resource list containing the stories which appear in this comic.,
    public EventList events; // A resource list containing the events in which this comic appears.

}
