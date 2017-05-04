package org.tensorflow.demo;

import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Surface;
import android.view.TextureView;

import java.io.IOException;

public class MainActivity extends Activity implements TextureView.SurfaceTextureListener {


    private MediaPlayer mMediaPlayer;

    private TextureView mPreview;

    @Override
    public void onCreate(Bundle icicle) {

        super.onCreate(icicle);

        mPreview = (TextureView) findViewById(R.id.texture);
        mPreview.setSurfaceTextureListener(this);
        setContentView(mPreview);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        Surface s = new Surface(surface);

        try {
            mMediaPlayer= new MediaPlayer();
            mMediaPlayer.setDataSource("http://daily3gp.com/vids/747.3gp");
            mMediaPlayer.setSurface(s);
            try {
                mMediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mMediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
                @Override
                public void onBufferingUpdate(MediaPlayer mp, int percent) {

                }
            });
            mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {

                }
            });
            mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {

                }
            });
            mMediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                @Override
                public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {

                }
            });
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mMediaPlayer.start();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * Invoked when the {@link SurfaceTexture}'s buffers size changed.
     *
     * @param surface The surface returned by
     *                {@link TextureView#getSurfaceTexture()}
     * @param width   The new width of the surface
     * @param height  The new height of the surface
     */
    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

    }

    /**
     * Invoked when the specified {@link SurfaceTexture} is about to be destroyed.
     * If returns true, no rendering should happen inside the surface texture after this method
     * is invoked. If returns false, the client needs to call {@link SurfaceTexture#release()}.
     * Most applications should return true.
     *
     * @param surface The surface about to be destroyed
     */
    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        return false;
    }

    /**
     * Invoked when the specified {@link SurfaceTexture} is updated through
     * {@link SurfaceTexture#updateTexImage()}.
     *
     * @param surface The surface just updated
     */
    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {

    }
}
