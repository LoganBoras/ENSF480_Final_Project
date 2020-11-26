package TRA.Control;

import TRA.Domain.TRA;

public class HomeController extends Controller {

    TRAController parentController;

    /**
     * Prevent default constructor from being called
     */
    private HomeController() {

    }

    public HomeController(TRAController traController) {
        this.parentController = traController;
    }

    @Override
    public void doAction() {

    }

    public void orderButtonAction() {
        this.parentController.doOrderSelection();
    }
}
