package r2l.xboxc.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.controllers.PovDirection;
import com.badlogic.gdx.controllers.mappings.Xbox;
import r2l.xboxc.hardwareAbstraction.ControllerItem;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HardwareCoordinates {

    private static final List<HardwareItem> HARDWARE_ITEM_COORDINATES = new ArrayList<>();
    private static final HardwareItem UNKNOWN = new HardwareItem(ControllerItem.UNKNOWN, createCoordinates(-100,-100));

    private static class HardwareItem {

        final ControllerItem controllerItem;
        final Point coordinate;

        public HardwareItem(ControllerItem controllerItem, Point coordinate) {
            this.controllerItem = controllerItem;
            this.coordinate = coordinate;
        }
    }

    static {
        HARDWARE_ITEM_COORDINATES.add(new HardwareItem(ControllerItem.A, createCoordinates(518,240)));
        HARDWARE_ITEM_COORDINATES.add(new HardwareItem(ControllerItem.B, createCoordinates(573,195)));
        HARDWARE_ITEM_COORDINATES.add(new HardwareItem(ControllerItem.X, createCoordinates(466,200)));
        HARDWARE_ITEM_COORDINATES.add(new HardwareItem(ControllerItem.Y, createCoordinates(523,157)));
        HARDWARE_ITEM_COORDINATES.add(new HardwareItem(ControllerItem.GUIDE, createCoordinates(321,202)));
        HARDWARE_ITEM_COORDINATES.add(new HardwareItem(ControllerItem.L_BUMPER, createCoordinates(122,83)));
        HARDWARE_ITEM_COORDINATES.add(new HardwareItem(ControllerItem.R_BUMPER, createCoordinates(524,83)));
        HARDWARE_ITEM_COORDINATES.add(new HardwareItem(ControllerItem.BACK, createCoordinates(251,204)));
        HARDWARE_ITEM_COORDINATES.add(new HardwareItem(ControllerItem.START, createCoordinates(396,204)));
        HARDWARE_ITEM_COORDINATES.add(new HardwareItem(ControllerItem.DPAD_UP, createCoordinates(222,277)));
        HARDWARE_ITEM_COORDINATES.add(new HardwareItem(ControllerItem.DPAD_DOWN, createCoordinates(222,332)));
        HARDWARE_ITEM_COORDINATES.add(new HardwareItem(ControllerItem.DPAD_LEFT, createCoordinates(185,303)));
        HARDWARE_ITEM_COORDINATES.add(new HardwareItem(ControllerItem.DPAD_RIGHT, createCoordinates(260,303)));
        HARDWARE_ITEM_COORDINATES.add(new HardwareItem(ControllerItem.L_STICK, createCoordinates(125,231)));
        HARDWARE_ITEM_COORDINATES.add(new HardwareItem(ControllerItem.R_STICK, createCoordinates(414,323)));
        HARDWARE_ITEM_COORDINATES.add(new HardwareItem(ControllerItem.NORTH, createCoordinates(222,277)));
        HARDWARE_ITEM_COORDINATES.add(new HardwareItem(ControllerItem.NORTH_EAST, createCoordinates(253,281)));
        HARDWARE_ITEM_COORDINATES.add(new HardwareItem(ControllerItem.EAST, createCoordinates(260,303)));
        HARDWARE_ITEM_COORDINATES.add(new HardwareItem(ControllerItem.SOUTH_EAST, createCoordinates(255,329)));
        HARDWARE_ITEM_COORDINATES.add(new HardwareItem(ControllerItem.SOUTH, createCoordinates(222,332)));
        HARDWARE_ITEM_COORDINATES.add(new HardwareItem(ControllerItem.SOUTH_WEST, createCoordinates(193,329)));
        HARDWARE_ITEM_COORDINATES.add(new HardwareItem(ControllerItem.WEST, createCoordinates(185,303)));
        HARDWARE_ITEM_COORDINATES.add(new HardwareItem(ControllerItem.NORTH_WEST, createCoordinates(193,281)));
        HARDWARE_ITEM_COORDINATES.add(new HardwareItem(ControllerItem.CENTER, createCoordinates(222,305)));
        HARDWARE_ITEM_COORDINATES.add(new HardwareItem(ControllerItem.L_TRIGGER, createCoordinates(143,37)));
        HARDWARE_ITEM_COORDINATES.add(new HardwareItem(ControllerItem.R_TRIGGER, createCoordinates(506,35)));
        HARDWARE_ITEM_COORDINATES.add(new HardwareItem(ControllerItem.L_STICK_VERTICAL_AXIS, createCoordinates(125,231)));
        HARDWARE_ITEM_COORDINATES.add(new HardwareItem(ControllerItem.L_STICK_HORIZONTAL_AXIS, createCoordinates(125,231)));
        HARDWARE_ITEM_COORDINATES.add(new HardwareItem(ControllerItem.R_STICK_VERTICAL_AXIS, createCoordinates(414,323)));
        HARDWARE_ITEM_COORDINATES.add(new HardwareItem(ControllerItem.R_STICK_HORIZONTAL_AXIS, createCoordinates(414,323)));
    }

    private static Point createCoordinates(int x, int y) {
        /* The Gimp gives coordinates with (0,0) in the upper left corner
           LibGDX draws the screen with coordinates origin in the lower left corner.
           Therefore I'm translating the coordinates here.  */
        int windowHeight = Gdx.graphics.getHeight();
        int markerOffset = Markers.controllerMarker(0).getRegionHeight() / 2;

        return new Point(x - markerOffset, windowHeight - y - markerOffset);
    }

    public static Point getCoordinates(ControllerItem controllerItem) {
        return getHardwareItem(controllerItem).coordinate;
    }

    private static HardwareItem getHardwareItem(ControllerItem controllerItem) {
        return HARDWARE_ITEM_COORDINATES.stream()
                .filter(item -> item.controllerItem.equals(controllerItem))
                .findFirst()
                .orElse(UNKNOWN);
    }

    public static List<ControllerItem> getHardwareItems() {
        return HARDWARE_ITEM_COORDINATES.stream()
                .map(hardwareItem -> hardwareItem.controllerItem)
                .collect(Collectors.toList());
    }
}
