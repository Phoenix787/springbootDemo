package springboot.entity;

public class SiteDto {
    private String favicon_url;
    private String audience;
    private String site_url;
    private String name;


    public SiteDto() {
    }

    public String getFavicon_url() {
        return this.favicon_url;
    }

    public String getAudience() {
        return this.audience;
    }

    public String getSite_url() {
        return this.site_url;
    }

    public String getName() {
        return this.name;
    }

    public void setFavicon_url(String favicon_url) {
        this.favicon_url = favicon_url;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public void setSite_url(String site_url) {
        this.site_url = site_url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof SiteDto)) return false;
        final SiteDto other = (SiteDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$favicon_url = this.getFavicon_url();
        final Object other$favicon_url = other.getFavicon_url();
        if (this$favicon_url == null ? other$favicon_url != null : !this$favicon_url.equals(other$favicon_url))
            return false;
        final Object this$audience = this.getAudience();
        final Object other$audience = other.getAudience();
        if (this$audience == null ? other$audience != null : !this$audience.equals(other$audience)) return false;
        final Object this$site_url = this.getSite_url();
        final Object other$site_url = other.getSite_url();
        if (this$site_url == null ? other$site_url != null : !this$site_url.equals(other$site_url)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $favicon_url = this.getFavicon_url();
        result = result * PRIME + ($favicon_url == null ? 43 : $favicon_url.hashCode());
        final Object $audience = this.getAudience();
        result = result * PRIME + ($audience == null ? 43 : $audience.hashCode());
        final Object $site_url = this.getSite_url();
        result = result * PRIME + ($site_url == null ? 43 : $site_url.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof SiteDto;
    }

    public String toString() {
        return "SiteDto(favicon_url=" + this.getFavicon_url() + ", audience=" + this.getAudience() + ", site_url=" + this.getSite_url() + ", name=" + this.getName() + ")";
    }
}
