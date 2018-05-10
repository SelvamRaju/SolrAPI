package com.tandf.solrj.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="titles")

public class TitleModel {
	
	private String summary;

    private String edition;

    private String pdfSize;

    private String groupOfCompanyCode;

    private Formats[] formats;

    private String bookClass;

    private String subjectGroupCode;

    private BisacSubjectHeadings[] bisacSubjectHeadings;

    private String imprint;

    private String isEditedCollection;

    private String description;

    private String features;

    private String bookClassCode;

    private String divisionCode;

    private String salesEvaluationCode;

    private String reviews;

    private String[] keywords;

    private String status;

    private String[] censoredTerritories;

    private String[] allIsbns;

    private String copyright;

    private String salesEvaluation;

    private String ownershipCode;

    private String masterEditionId;

    private String bio;

    private String ownership;

    private String eId;

    private String formerImprint;

    private String language;

    private String formerImprintCode;

    private String titleId;

    private String series;

    private String dataSource;

    private String toc;

    private String publisher;

    private String statusCode;

    private Originators[] originators;

    private String title;

    private String publisherCode;

    private String division;

    private String subjectGroup;

    private String pagesArabic;

    private String pages;

    private String __v;

    private String bookshopCategory;

    private String eIsbn;

    private String previewPdfSize;

    private String imprintCode;

    private String languageCode;

    private String contentIsbn;

    private String shortTitle;

    private String subtitle;

    private String pagesRoman;

    private String dacKey;

    private String doi;

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getPdfSize() {
		return pdfSize;
	}

	public void setPdfSize(String pdfSize) {
		this.pdfSize = pdfSize;
	}

	public String getGroupOfCompanyCode() {
		return groupOfCompanyCode;
	}

	public void setGroupOfCompanyCode(String groupOfCompanyCode) {
		this.groupOfCompanyCode = groupOfCompanyCode;
	}

	public Formats[] getFormats() {
		return formats;
	}

	public void setFormats(Formats[] formats) {
		this.formats = formats;
	}

	public String getBookClass() {
		return bookClass;
	}

	public void setBookClass(String bookClass) {
		this.bookClass = bookClass;
	}

	public String getSubjectGroupCode() {
		return subjectGroupCode;
	}

	public void setSubjectGroupCode(String subjectGroupCode) {
		this.subjectGroupCode = subjectGroupCode;
	}

	public BisacSubjectHeadings[] getBisacSubjectHeadings() {
		return bisacSubjectHeadings;
	}

	public void setBisacSubjectHeadings(BisacSubjectHeadings[] bisacSubjectHeadings) {
		this.bisacSubjectHeadings = bisacSubjectHeadings;
	}

	public String getImprint() {
		return imprint;
	}

	public void setImprint(String imprint) {
		this.imprint = imprint;
	}

	public String getIsEditedCollection() {
		return isEditedCollection;
	}

	public void setIsEditedCollection(String isEditedCollection) {
		this.isEditedCollection = isEditedCollection;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public String getBookClassCode() {
		return bookClassCode;
	}

	public void setBookClassCode(String bookClassCode) {
		this.bookClassCode = bookClassCode;
	}

	public String getDivisionCode() {
		return divisionCode;
	}

	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}

	public String getSalesEvaluationCode() {
		return salesEvaluationCode;
	}

	public void setSalesEvaluationCode(String salesEvaluationCode) {
		this.salesEvaluationCode = salesEvaluationCode;
	}

	public String getReviews() {
		return reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}

	public String[] getKeywords() {
		return keywords;
	}

	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String[] getCensoredTerritories() {
		return censoredTerritories;
	}

	public void setCensoredTerritories(String[] censoredTerritories) {
		this.censoredTerritories = censoredTerritories;
	}

	public String[] getAllIsbns() {
		return allIsbns;
	}

	public void setAllIsbns(String[] allIsbns) {
		this.allIsbns = allIsbns;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getSalesEvaluation() {
		return salesEvaluation;
	}

	public void setSalesEvaluation(String salesEvaluation) {
		this.salesEvaluation = salesEvaluation;
	}

	public String getOwnershipCode() {
		return ownershipCode;
	}

	public void setOwnershipCode(String ownershipCode) {
		this.ownershipCode = ownershipCode;
	}

	public String getMasterEditionId() {
		return masterEditionId;
	}

	public void setMasterEditionId(String masterEditionId) {
		this.masterEditionId = masterEditionId;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getOwnership() {
		return ownership;
	}

	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}

	public String geteId() {
		return eId;
	}

	public void seteId(String eId) {
		this.eId = eId;
	}

	public String getFormerImprint() {
		return formerImprint;
	}

	public void setFormerImprint(String formerImprint) {
		this.formerImprint = formerImprint;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getFormerImprintCode() {
		return formerImprintCode;
	}

	public void setFormerImprintCode(String formerImprintCode) {
		this.formerImprintCode = formerImprintCode;
	}

	public String getTitleId() {
		return titleId;
	}

	public void setTitleId(String titleId) {
		this.titleId = titleId;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getToc() {
		return toc;
	}

	public void setToc(String toc) {
		this.toc = toc;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public Originators[] getOriginators() {
		return originators;
	}

	public void setOriginators(Originators[] originators) {
		this.originators = originators;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisherCode() {
		return publisherCode;
	}

	public void setPublisherCode(String publisherCode) {
		this.publisherCode = publisherCode;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}


	public String getSubjectGroup() {
		return subjectGroup;
	}

	public void setSubjectGroup(String subjectGroup) {
		this.subjectGroup = subjectGroup;
	}

	public String getPagesArabic() {
		return pagesArabic;
	}

	public void setPagesArabic(String pagesArabic) {
		this.pagesArabic = pagesArabic;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public String get__v() {
		return __v;
	}

	public void set__v(String __v) {
		this.__v = __v;
	}

	public String getBookshopCategory() {
		return bookshopCategory;
	}

	public void setBookshopCategory(String bookshopCategory) {
		this.bookshopCategory = bookshopCategory;
	}

	public String geteIsbn() {
		return eIsbn;
	}

	public void seteIsbn(String eIsbn) {
		this.eIsbn = eIsbn;
	}

	public String getPreviewPdfSize() {
		return previewPdfSize;
	}

	public void setPreviewPdfSize(String previewPdfSize) {
		this.previewPdfSize = previewPdfSize;
	}

	public String getImprintCode() {
		return imprintCode;
	}

	public void setImprintCode(String imprintCode) {
		this.imprintCode = imprintCode;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getContentIsbn() {
		return contentIsbn;
	}

	public void setContentIsbn(String contentIsbn) {
		this.contentIsbn = contentIsbn;
	}

	public String getShortTitle() {
		return shortTitle;
	}

	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getPagesRoman() {
		return pagesRoman;
	}

	public void setPagesRoman(String pagesRoman) {
		this.pagesRoman = pagesRoman;
	}

	public String getDacKey() {
		return dacKey;
	}

	public void setDacKey(String dacKey) {
		this.dacKey = dacKey;
	}

	public String getDoi() {
		return doi;
	}

	public void setDoi(String doi) {
		this.doi = doi;
	}
    
    


}
