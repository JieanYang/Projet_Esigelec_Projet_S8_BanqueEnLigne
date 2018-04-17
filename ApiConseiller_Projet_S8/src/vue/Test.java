package vue;

public class Test {

	public static void main(String[] args) {
		MainFrame mFrame = new MainFrame();
		AllPanel allPanel = new AllPanel(mFrame);
		mFrame.setPanel(allPanel.loginPanel());
	}
}
