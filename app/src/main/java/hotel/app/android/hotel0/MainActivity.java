package hotel.app.android.hotel0;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;

public class MainActivity extends AppCompatActivity implements OnGetGeoCoderResultListener {

    Button btn;
    GeoCoder mSearch = null; // 搜索模块，也可去掉地图模块独立使用
    BaiduMap mBaiduMap = null;
    MapView mMapView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 地图初始化
        mMapView = (MapView) findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();

        // 初始化搜索模块，注册事件监听
        mSearch = GeoCoder.newInstance();
        mSearch.setOnGetGeoCodeResultListener(this);
        btn = (Button) findViewById(R.id.btn_click);
        searchButtonProcess();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    /**
     * 发起搜索
     */
    public void searchButtonProcess() {

        LatLng ptCenter = new LatLng(31.210373,121.550323);
        // 反Geo搜索
        mSearch.reverseGeoCode(new ReverseGeoCodeOption()
                .location(ptCenter));
       /*else if (v.getId() == R.id.geocode) {
            EditText editCity = (EditText) findViewById(R.id.city);
            EditText editGeoCodeKey = (EditText) findViewById(R.id.geocodekey);
            // Geo搜索
            mSearch.geocode(new GeoCodeOption().city(
                    editCity.getText().toString()).address(editGeoCodeKey.getText().toString()));
        }*/
    }


    @Override
    public void onGetGeoCodeResult(GeoCodeResult result) {
        if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
            Toast.makeText(this, "抱歉，未能找到结果", Toast.LENGTH_LONG)
                    .show();
            return;
        }
        mBaiduMap.clear();
        mBaiduMap.addOverlay(new MarkerOptions().position(result.getLocation())
                .icon(BitmapDescriptorFactory
                        .fromResource(R.drawable.icon_marka)));
        mBaiduMap.setMapStatus(MapStatusUpdateFactory.newLatLng(result
                .getLocation()));
        String strInfo = String.format("纬度：%f 经度：%f",
                result.getLocation().latitude, result.getLocation().longitude);
        Toast.makeText(this, strInfo, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onGetReverseGeoCodeResult(ReverseGeoCodeResult result) {
        if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
            Toast.makeText(this, "抱歉，未能找到结果", Toast.LENGTH_LONG)
                    .show();
            return;
        }
        mBaiduMap.clear();
        mBaiduMap.addOverlay(new MarkerOptions().position(result.getLocation())
                .icon(BitmapDescriptorFactory
                        .fromResource(R.drawable.icon_marka)));
        mBaiduMap.setMapStatus(MapStatusUpdateFactory.newLatLng(result
                .getLocation()));
        Toast.makeText(this, result.getAddress(),
                Toast.LENGTH_LONG).show();

    }

}
