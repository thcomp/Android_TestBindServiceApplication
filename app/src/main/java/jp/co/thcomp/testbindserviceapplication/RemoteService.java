package jp.co.thcomp.testbindserviceapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class RemoteService extends Service {
    private static final String TAG = RemoteService.class.getSimpleName();
    private int mValue = 0;

    private IRemoteService.Stub mStub = new IRemoteService.Stub() {
        @Override
        public int addValue(int value) throws RemoteException {
            Log.i(TAG, "Before: mValue = " + mValue);
            mValue += value;
            Log.i(TAG, "After: mValue = " + mValue);
            return mValue;
        }
    };

    public RemoteService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, RemoteService.class.getSimpleName() + ".onBind");
        return mStub.asBinder();
    }
}
