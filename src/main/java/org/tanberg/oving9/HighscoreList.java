package org.tanberg.oving9;

import java.util.Comparator;

public class HighscoreList extends ObservableList<Integer> {

    public HighscoreList(int sizeLimit) {
        super(sizeLimit);
    }

    @Override
    protected void makeSpace() {
        this.remove(this.size() - 1); // Remove worst score
    }

    @Override
    protected void notifyChange(Integer val, boolean removed) {
        this.sort(Comparator.naturalOrder());
        super.notifyChange(val, removed);
    }

    public void addObservableListListener(HighscoreChangeListener listener) {
        this.subscribe(listener);
    }

    public void removeObservableListListener(HighscoreChangeListener listener) {
        this.unsubscribe(listener);
    }

    public void addResult(int result) {
        if (this.isFull() && result >= this.getElement(this.size() - 1)) {
            // No space for this loser
            return;
        }

        this.add(result);
    }
}
