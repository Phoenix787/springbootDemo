package springboot.entity;

import java.util.List;

public class SitesDto {
    private List<SiteDto> items;

    public SitesDto() {
    }

    public List<SiteDto> getItems() {
        return items;
    }

    public void setItems(List<SiteDto> items) {
        this.items = items;
    }
}
