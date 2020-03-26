package org.tanberg.oving9;

public interface HighscoreChangeListener extends ListChangeListener<Integer> {

    @Override
    default void onListChange(ObservableList<Integer> list, Integer value, boolean added) {
        if (!added) {
            return;
        }

        // Hacky fix, but we should be fine. Always have the last result at the last index, and there really is no
        // other way to differentiate between the results in this horrible structure.
        this.onListChange((HighscoreList) list, list.lastIndexOf(value));
    }

    void onListChange(HighscoreList list, int position);
}
