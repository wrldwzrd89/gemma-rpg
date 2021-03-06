/*  Gemma: An RPG
 Copyright (C) 2013-2014 Eric Ahnell

 Any questions should be directed to the author via email at: support@puttysoftware.com
 */
package com.puttysoftware.gemma.support.map.objects;

import com.puttysoftware.gemma.support.map.generic.GenericGround;
import com.puttysoftware.gemma.support.map.generic.TemplateTransform;

public class Sand extends GenericGround {
    // Constructors
    public Sand() {
        super();
        this.setTemplateTransform(new TemplateTransform(1.0, 0.8, 0.6));
    }

    @Override
    public String getName() {
        return "Sand";
    }

    @Override
    public String getPluralName() {
        return "Squares of Sand";
    }

    @Override
    public String getDescription() {
        return "Sand is one of the many types of ground.";
    }

    @Override
    public String getGameImageNameHook() {
        return "textured";
    }

    @Override
    public String getEditorImageNameHook() {
        return "textured";
    }
}
