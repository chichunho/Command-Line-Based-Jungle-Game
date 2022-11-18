package clj.model;

/**
 * This provide a interface for model to update the view
 */
public interface ModelViewInterface {
    /**
     * The function for model to send a response to view
     * @param response      The infomation that view needed to print the model response
     */
    abstract void modelUpdateView(Response response);
}
