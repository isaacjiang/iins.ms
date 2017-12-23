package com.iins.system.menuitem;

public class MenuItem {
    private String parentId;
    private String parentMenu;
    private String id;
    private String previous;
    private String itemName;
    private String itemKey;
    private String description;
    private Integer status = 1;
    private Boolean visible = true;

    public MenuItem() {
    }

    public MenuItem(String id, String itemName, String itemKey, String parentId, String parentMenu) {
        this.parentId = parentId;
        this.id = id;
        this.itemName = itemName;
        this.itemKey = itemKey;
        this.parentId = parentId;
        this.parentMenu = parentMenu;
        this.description = "";
    }

    public MenuItem(String id, String itemName, String itemKey, String parentId, String parentMenu, String description, Integer status, Boolean visible) {
        this.parentId = parentId;
        this.id = id;
        this.itemName = itemName;
        this.itemKey = itemKey;
        this.parentId = parentId;
        this.parentMenu = parentMenu;
        this.description = description;
        this.status = status;
        this.visible = visible;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(String parentMenu) {
        this.parentMenu = parentMenu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemKey() {
        return itemKey;
    }

    public void setItemKey(String itemKey) {
        this.itemKey = itemKey;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
}
