package com.sewageproject.ui.fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.sewageproject.base.BaseVmFragment
import com.sewageproject.databinding.VideofragmentBinding
import com.sewageproject.net.http.Api
import com.sewageproject.ui.fragment.adapter.SewageRightAdapter
import com.sewageproject.ui.fragment.adapter.sewageLeftAdapter
import com.sewageproject.ui.fragment.bean.Record3
import com.sewageproject.ui.fragment.bean.Video
import com.sewageproject.ui.fragment.bean.WuShuiVideoViewListBean
import com.sewageproject.ui.fragment.viewmodel.VideoViewModel
import java.util.*

/**
 * 视频
 */
class VideoMvpFragment :
    BaseVmFragment<VideofragmentBinding, VideoViewModel>() {
    var urlAD = "hls/video14/test.m3u8"
    override fun initView() {
    }
    var sewageLeftAdapter: sewageLeftAdapter? = null
    var sewagerightAdapter: SewageRightAdapter? = null
    val sewageRightData: MutableList<Video> =
        ArrayList()
    val sewageRightAllData: MutableList<Video> =
        ArrayList()
    var bean: WuShuiVideoViewListBean?=null
    override fun initData() {
        binding!!.detailPlayer.setUpLazy(Api.Companion.BASE_VidEOURL+urlAD, true, null, null, "")
        //增加title
        binding!!.detailPlayer.titleTextView.visibility = View.GONE
        //设置返回键
        binding!!.detailPlayer.backButton.visibility = View.GONE
        //设置全屏按键功能
        binding!!.detailPlayer.fullscreenButton
            .setOnClickListener {
                binding!!.detailPlayer.startWindowFullscreen(
                    context, false, true
                )
            }
        //是否根据视频尺寸，自动选择竖屏全屏或者横屏全屏
        binding!!.detailPlayer.isAutoFullWithSize = true
        //音频焦点冲突时是否释放
        binding!!.detailPlayer.isReleaseWhenLossAudio = false
        //全屏动画
        binding!!.detailPlayer.isShowFullAnimation = true
        //小屏时不触摸滑动
        binding!!.detailPlayer.setIsTouchWiget(false)
        sewageLeftAdapter = sewageLeftAdapter(null)
        binding!!.sewageLeftRecyclerView.adapter = sewageLeftAdapter
        sewageLeftAdapter!!.setOnItemClickListener { adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int ->
            bean?.records?.forEach {
                it.status=false
            }
            bean?.records?.get(position)?.status=true
            if(position==0){
                choseAddVideo(10000)
            }else {
                choseAddVideo(position-1)
            }
        }
        sewagerightAdapter = SewageRightAdapter(sewageRightData)
        binding!!.sewageRightRecyclerView.adapter = sewagerightAdapter
        sewagerightAdapter?.setOnItemClickListener { adapter, view, position ->
            urlAD="hls/video"+ sewageRightData[position].id+"/test.m3u8"
            binding!!.detailPlayer.setUpLazy(Api.Companion.BASE_VidEOURL+urlAD, true, null, null, "")
            binding!!.detailPlayer.startPlayLogic()
        }
        binding!!.detailPlayer.startPlayLogic()
        binding?.tvEditText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
            override fun afterTextChanged(s: Editable?) {
                sewageRightData.clear()
                if(binding?.tvEditText?.text.toString().isNotEmpty()){
                    sewageRightAllData.forEach {
                        if(it.name.contains(binding?.tvEditText?.text.toString())){
                        sewageRightData.add(it)
                        }
                    }
                }else{
                    sewageRightData.addAll(sewageRightAllData)
                }
                sewagerightAdapter?.notifyDataSetChanged()
            }
        })
        mViewModel.wuShuiVideoViewList(pageNo.toString())
    }
    private var pageNo=0
    /**
     * 获取ViewModel的class
     */
    override fun viewModelClass(): Class<VideoViewModel> = VideoViewModel::class.java

    override fun getViewBinding(): VideofragmentBinding {
      return  VideofragmentBinding.inflate(layoutInflater)
    }

    override fun setListener() {

    }
    override fun observe() {
        mViewModel.warnBean.observe(this,{
            bean=it
            it.records.add(0,Record3(0,"全部", emptyList(),true))
                sewageLeftAdapter?.setNewData(it.records)
            choseAddVideo(10000)
        })
    }

   private fun choseAddVideo(index:Int){
        sewageRightData.clear()
        if(index==10000){
            bean?.records?.forEach { videoItem ->
                videoItem.videoList.forEach {
                    it.url="/wsfkcut/"+videoItem.id+"-"+it.ch+".jpg"
                }
                sewageRightData.addAll(videoItem.videoList)
                sewageRightAllData.addAll(videoItem.videoList)
            }
        }else{
            bean?.records?.get(index)?.videoList?.forEach {
                it.url="/wsfkcut/"+ bean?.records?.get(index)?.id +"-"+it.ch+".jpg"
            }
            bean?.records?.get(index)?.videoList?.let {
                sewageRightData.addAll(it)
                sewageRightAllData.addAll(it)
            }
        }
        sewageLeftAdapter?.notifyDataSetChanged()
    }
}