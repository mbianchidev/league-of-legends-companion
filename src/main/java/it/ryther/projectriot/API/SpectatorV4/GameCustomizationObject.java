package it.ryther.projectriot.API.SpectatorV4;

import com.google.common.base.MoreObjects;

public class GameCustomizationObject {
    private String category;  // Category identifier for Game Customization
    private String content;   // Game Customization content

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("category", category)
                .add("content", content)
                .toString();
    }
}
