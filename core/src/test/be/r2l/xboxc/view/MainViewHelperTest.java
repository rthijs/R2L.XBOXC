package test.be.r2l.xboxc.view;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import be.r2l.xboxc.XboxControllerObservable;
import be.r2l.xboxc.view.BackGround;
import be.r2l.xboxc.view.MainViewHelper;
import be.r2l.xboxc.view.MarkerOverlay;
import be.r2l.xboxc.view.XboxControllerImage;
import be.r2l.xboxc.view.XboxControllerOverlay;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.mockito.Mockito.mock;

public class MainViewHelperTest {
	
	private static float WIDTH = 100f;
	private static float HEIGHT = 100f;

    private Batch mockBatch;
    private XboxControllerObservable mockXboxControllerObservable;
    private MainViewHelper mainViewHelper;

    @Before
    public void setup() {
        mockBatch = mock(SpriteBatch.class);
        mockXboxControllerObservable = mock(XboxControllerObservable.class);
        mainViewHelper = new MainViewHelperForTesting(mockBatch, mockXboxControllerObservable);
    }

    @Test
    public void getBackGround_shouldReturnBackGround() {
        BackGround backGround = mainViewHelper.getBackGround();
        assertThat(backGround, instanceOf(BackGround.class));
    }

    @Test
    public void getXboxControllerImage_shouldReturnXboxControllerImage() {
        XboxControllerImage xboxControllerImage = mainViewHelper.getXboxControllerImage();
        assertThat(xboxControllerImage, instanceOf(XboxControllerImage.class));
    }
    
    @Test
    public void getXboxControllerOverlay_shouldReturnXboxControllerOverlay() {
    	XboxControllerOverlay xboxControllerOverlay = mainViewHelper.getXboxControllerOverlay();
    	assertThat(xboxControllerOverlay, instanceOf(XboxControllerOverlay.class));
    }
    
    @Test
    public void getMarkerOverlay_shouldReturnMarkerOverlay() {
    	MarkerOverlay markerOverlay = mainViewHelper.getMarkerOverlay();
    	assertThat(markerOverlay, instanceOf(MarkerOverlay.class));
    }

    private class MainViewHelperForTesting extends MainViewHelper {
    	
        public MainViewHelperForTesting(Batch batch, XboxControllerObservable observable) {
            super(batch, observable);
        }
        
        @Override
        protected BackGround initializeBackground() {
        	return mock(BackGround.class);
    	}
        
        @Override
    	protected XboxControllerImage initializeXboxControllerImage() {
    		return mock(XboxControllerImage.class);
    	}
        
        @Override
    	protected XboxControllerOverlay initializeXboxControllerOverlay() {
    		return mock(XboxControllerOverlay.class);
    	}
        
        @Override
    	protected MarkerOverlay initializeMarkerOverlay() {
    		return mock(MarkerOverlay.class);
    	}
        
        @Override
        protected float getWidth() {
        	return WIDTH;
        }
        
        @Override
        protected float getHeight() {
        	return HEIGHT;
        }
    }
}
