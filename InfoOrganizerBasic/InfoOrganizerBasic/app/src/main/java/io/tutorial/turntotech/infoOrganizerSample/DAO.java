package io.tutorial.turntotech.infoOrganizerSample;

import java.util.ArrayList;

/**
 * Created by Jeremy on 7/27/2017.
 */

public class DAO {

    private static ArrayList<Company> companyList;
    private static int companyNo, productNo;

    static DAO instance;
    public static DAO getInstance(){
        if (instance == null){
            instance = new DAO();
        }
        return instance;
    }

    public static ArrayList<Company> getcompanyList(){
        return companyList;
    }

    public static int getCompanyNo(){
        return companyNo;
    }

    public static void setCompanyNo(int i){
        companyNo = i;
    }

    public static int getProductNo(){
        return productNo;
    }

    public static void setProductNo(int i){
        productNo = i;
    }

    private DAO(){
        companyList = new ArrayList<Company>();
        Company Apple = new Company("Apple", "http://pngimg.com/uploads/apple_logo/apple_logo_PNG19675.png");
        Apple.products.add(new Product("iPhone",
                "https://staticshop.o2.co.uk/product/images/apple_iphone_7_plus_128gb_red_sku_header.png?cb=2077cd5d85e2dd9b6905a70ad30e33ba",
                "https://www.apple.com/iphone/"));
        Apple.products.add(new Product("iPad",
                "https://pisces.bbystatic.com/BestBuy_US/store/rtb/experience/apple/images/iPad-img.png",
                "https://www.apple.com/ipad/"));
        Apple.products.add(new Product("Macintosh",
                "https://www.imobie.com/support/img/retina-macbook-12-inch.png",
                "https://www.apple.com/mac/"));

        Company Samsung = new Company("Samsung", "http://assets.stickpng.com/thumbs/580b57fcd9996e24bc43c533.png");
        Samsung.products.add(new Product("Galaxy S",
                "http://store.virginmedia.com/content/dam/eSales/mobile/responsive/Samsung/Zoom/galaxy_s8_grey_comp.png",
                "http://www.samsung.com/us/explore/galaxy-s8/"));
        Samsung.products.add(new Product("Galaxy Note",
                "http://www.adweek.com/wp-content/uploads/files/2016_Sep/note7_samsung-fire-hed-2016.png",
                "https://www.phonearena.com/phones/Samsung-Galaxy-Note-Fan-Edition_id10591"));
        Samsung.products.add(new Product("Galaxy Book",
                "http://images.samsung.com/is/image/samsung/p5/uk/pcd/mobile/PCD_Mobile_Tablet_03_Featurebenefit_PC_img_20160831.png?$ORIGIN_PNG$",
                "http://www.samsung.com/us/explore/galaxy-book/"));

        Company Motorola = new Company("Motorola", "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c9/Motorola_Mobility_Logo_2015.svg/1280px-Motorola_Mobility_Logo_2015.svg.png");
        Motorola.products.add(new Product("Moto Z",
                "http://www.zailet.com/posts/post60/3.jpg",
                "https://www.motorola.com/us/products/moto-z-force-edition-gen-2"));
        Motorola.products.add(new Product("Moto G",
                "http://www3.lenovo.com/medias/lenovo-moto-g5-plus-hero.png?context=bWFzdGVyfGltYWdlc3w5MTE5M3xpbWFnZS9wbmd8aW1hZ2VzL2gxMy9oZDgvOTQwMTc4NjY2Mjk0Mi5wbmd8Y2VhMDgxNDg3ZjQwZDJkNGM3OWFmMzJjNzcxNjljY2JhNDA4ZjI5YzMyMDY1NTgzNjc4MWVhOTVmOTM1Y2M5ZA",
                "https://www.motorola.com/us/products/moto-g-plus"));
        Motorola.products.add(new Product("Moto E",
                "https://www.motorola.com/sites/default/files/library/storage/products/smartphones/moto-e4-plus-NA-1000.png",
                "https://www.motorola.com/us/products/moto-e-plus-gen-4"));

        Company Microsoft = new Company("Microsoft", "http://pngimg.com/uploads/microsoft/microsoft_PNG16.png");
        Microsoft.products.add(new Product("Xbox One",
                "http://images.bbycastatic.ca/sf/projects/projectscorpio/assets/xbox-one-x-console.png",
                "http://www.xbox.com/en-us/xbox-one-x"));
        Microsoft.products.add(new Product("Surface Pro",
                "https://surfacetip.com/wp-content/uploads/2017/01/surface-pro-4-png-1-300x169.png",
                "https://www.microsoft.com/en-us/surface/devices/surface-pro/overview"));
        Microsoft.products.add(new Product("Surface Laptop",
                "https://d243u7pon29hni.cloudfront.net/images/products/portatil-microsoft-surface-london-platino-1364584-10_ad_l.png",
                "https://www.microsoft.com/en-us/surface/devices/surface-laptop/overview"));

        Company LG = new Company("LG", "https://seeklogo.com/images/L/LG-logo-1409344847-seeklogo.com.png");
        LG.products.add(new Product("LG G",
                "https://www.androidcentral.com/sites/androidcentral.com/files/styles/large/public/topic_images/2017/lg-g6-02.png?itok=6GoJ4X3S",
                "http://www.lg.com/us/mobile-phones/g6"));
        LG.products.add(new Product("LG Gram",
                "http://www.lg.com/us/images/stepupChart/15z.png",
                "http://www.lg.com/us/laptops"));
        LG.products.add(new Product("LG OLED TV",
                "https://www.fouanistore.com/images/thumbnails/465/465/detailed/3/_55%E2%80%9D_LG_OLED_TV_55EG910_(2).gif",
                "http://www.lg.com/us/oled-tvs"));

        Company HTC = new Company("HTC", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/ba/Htc_new_logo.svg/500px-Htc_new_logo.svg.png");
        HTC.products.add(new Product("HTC U11",
                "https://www.htc.com/managed-assets/shared/desktop/smartphones/htc-u11/explorer/en_US/htc-u11-black-global-phone-listing.png",
                "http://www.htc.com/us/smartphones/htc-u11/"));
        HTC.products.add(new Product("HTC U Ultra",
                "http://www.htc.com/managed-assets/shared/desktop/smartphones/htc-u-ultra/explorer/htc-u-ultra-blue-global-phone-listing.png",
                "http://www.htc.com/us/smartphones/htc-u-ultra/"));
        HTC.products.add(new Product("HTC Vive",
                "https://www.vive.com/media/filer_public/b8/96/b896b746-0118-4105-93b6-4270db79e1a1/product-vive-family-shot.png",
                "https://www.vive.com/us/"));

        companyList.add(Apple);
        companyList.add(Samsung);
        companyList.add(Motorola);
        companyList.add(Microsoft);
        companyList.add(LG);
        companyList.add(HTC);
    }

}