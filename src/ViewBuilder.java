import dataSources.comporators.AppComporator;
import dataSources.comporators.PriceComporator;
import dto.ProductDto;
import services.*;
import views.AppLoopNew;
import views.TerminalView;
import views.pages.*;
import views.pages.adminView.AdminAddProductView;
import views.pages.adminView.AdminCatalogView;
import views.pages.loginView.AuthorizationtView;
import views.pages.loginView.LogInView;
import views.pages.loginView.RegistrationView;
import views.pages.userView.*;

import java.util.ArrayList;

public class ViewBuilder {

    public void starter() {
        ServiceBasket basket = new ServiceBasketImpl();
        ServiceProduct serviceProduct = new ServiceProductImpl();
        ServiceOrder serviceOrder = new ServiceOrderImpl();

        // --- Формируем меню пользователя
        ArrayList<TerminalView> startShopUser = new ArrayList<>();

        TerminalView orderView = new UserOrderView(basket, serviceOrder);
        TerminalView showBasketView = new UserShowBasketView(basket);
        TerminalView addToBasket = new UserAddToBasket(basket);

        ArrayList<TerminalView> addToBasketMenu = new ArrayList<>();
        addToBasketMenu.add(addToBasket);

        ArrayList<AppComporator<ProductDto>> catalogComporators = new ArrayList<>();
        catalogComporators.add(new AppComporator<>("Цена по возростанию", new PriceComporator()));
        catalogComporators.add(new AppComporator<>("Цена по убыванию", new PriceComporator(false)));


        TerminalView catalogViewUser = new UserCatalogView(serviceProduct, addToBasketMenu, catalogComporators);
        ArrayList<TerminalView> catalog = new ArrayList<>();
        catalog.add(catalogViewUser);
        catalog.add(addToBasket);
        TerminalView categorySelection = new CustomCategorySelection(serviceProduct, catalog);

        startShopUser.add(categorySelection);
        startShopUser.add(showBasketView);
        startShopUser.add(orderView);

        TerminalView shopViewUser = new ShopView(startShopUser);
        ArrayList<TerminalView> userMenu = new ArrayList<>();
        userMenu.add(shopViewUser);

        // --- Формируем меню администратора

        TerminalView productView = new AdminAddProductView(serviceProduct,new ArrayList<>());
        TerminalView adminCatalogView = new AdminCatalogView(serviceProduct);

        ArrayList<TerminalView> startAdminMenu = new ArrayList<>();
        startAdminMenu.add(productView);
        startAdminMenu.add(adminCatalogView);

        TerminalView shopViewAdmin = new ShopView(startAdminMenu);
        ArrayList<TerminalView> adminMenu = new ArrayList<>();
        adminMenu.add(shopViewAdmin);



        // --- Формируем меню входа и регистрации
        ArrayList<TerminalView> toLogin = new ArrayList<>();
        TerminalView registration = new RegistrationView(userMenu, adminMenu);
        TerminalView authorization = new AuthorizationtView(userMenu, adminMenu);

        toLogin.add(authorization);
        toLogin.add(registration);

        TerminalView logInView = new LogInView(toLogin);

        new AppLoopNew(logInView).run();


    }
}
