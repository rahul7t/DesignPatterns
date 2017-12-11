package spreadsheetUpdates.observer;

public interface SubjectInterface {
	public void registerObserver(Cell o);
	public void removeObserver(Cell o);
	public void notifyObserver();
}