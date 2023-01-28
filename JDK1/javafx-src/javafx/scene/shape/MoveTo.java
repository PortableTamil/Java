/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package javafx.scene.shape;

import com.sun.javafx.geom.Path2D;
import com.sun.javafx.sg.prism.NGPath;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.DoublePropertyBase;


/**
 * Creates an addition to the path by moving to the specified
 * coordinates.
 *
 * <p>For more information on path elements see the {@link Path} and
 * {@link PathElement} classes.
 *
 * <p>Example:
 *
<PRE>
import javafx.scene.shape.*;

Path path = new Path();
path.getElements().add(new MoveTo(0.0f, 0.0f));
path.getElements().add(new LineTo(100.0f, 100.0f));
</PRE>
 * @since JavaFX 2.0
 */
public class MoveTo extends PathElement {

    /**
     * Creates an empty instance of MoveTo.
     */
    public MoveTo() {
    }

    /**
     * Creates a new instance of MoveTo.
     * @param x the horizontal coordinate to move to
     * @param y the vertical coordinate to move to
     */
    public MoveTo(double x, double y) {
        setX(x);
        setY(y);
    }

    /**
     * Defines the specified X coordinate.
     *
     * @defaultValue 0.0
     */
    private DoubleProperty x;

    public final void setX(double value) {
        if (x != null || value != 0.0) {
            xProperty().set(value);
        }
    }

    public final double getX() {
        return x == null ? 0.0 : x.get();
    }

    public final DoubleProperty xProperty() {
        if (x == null) {
            x = new DoublePropertyBase() {

                @Override
                public void invalidated() {
                    u();
                }

                @Override
                public Object getBean() {
                    return MoveTo.this;
                }

                @Override
                public String getName() {
                    return "x";
                }
            };
        }
        return x;
    }

    /**
     * Defines the specified Y coordinate.
     *
     * @defaultValue 0.0
     */
    private DoubleProperty y;

    public final void setY(double value) {
        if (y != null || value != 0.0) {
            yProperty().set(value);
        }
    }

    public final double getY() {
        return y == null ? 0.0 : y.get();
    }

    public final DoubleProperty yProperty() {
        if (y == null) {
            y = new DoublePropertyBase() {

                @Override
                public void invalidated() {
                    u();
                }

                @Override
                public Object getBean() {
                    return MoveTo.this;
                }

                @Override
                public String getName() {
                    return "y";
                }
            };
        }
        return y;
    }

    @Override
    void addTo(NGPath pgPath) {
        if (isAbsolute()) {
            pgPath.addMoveTo((float)getX(), (float)getY());
        } else {
            pgPath.addMoveTo((float)(pgPath.getCurrentX() + getX()),
                             (float)(pgPath.getCurrentY() + getY()));
        }
    }

    /**
     * @treatAsPrivate implementation detail
     * @deprecated This is an internal API that is not intended for use and will be removed in the next version
     */
    @Deprecated
    @Override
    public void impl_addTo(Path2D path) {
        if (isAbsolute()) {
            path.moveTo((float)getX(), (float)getY());
        } else {
            path.moveTo((float)(path.getCurrentX() + getX()),
                        (float)(path.getCurrentY() + getY()));
        }
    }

    /**
     * Returns a string representation of this {@code MoveTo} object.
     * @return a string representation of this {@code MoveTo} object.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MoveTo[");
        sb.append("x=").append(getX());
        sb.append(", y=").append(getY());
        return sb.append("]").toString();
    }
}

