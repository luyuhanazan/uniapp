<template>
  <view class="mine-container" :style="{height: `${windowHeight}px`}">
    <!--顶部个人信息栏-->


    <view class="content-section">
      <view class="mine-actions grid col-3 text-center">
        <view class="action-item" @click="handlecollect">
          <image src="~@/static/images/icon/shoucang.svg" style="width: 40px; height: 40px;" />

          <text class="text" style="font-size: 14px;">64</text>
          <text class="text" style="font-size: 14px;">收藏</text>
        </view>
      
        <view class="action-item" @click="handlelike">
          <image src="~@/static/images/icon/xihuan.svg" style="width: 40px; height: 40px;" />
          <text class="text" style="font-size: 14px;">32</text>
          <text class="text" style="font-size: 14px;">喜欢</text>
        </view>
      
        <view class="action-item" @click="handlehistory">
          <image src="~@/static/images/icon/huanyihuan.svg"style="width: 40px; height: 40px;"/>
          <text class="text" style="font-size: 14px;">89</text>
          <text class="text" style="font-size: 14px;">浏览记录</text>
        </view>
      </view>

      <view class="menu-list">
        <view class="list-cell list-cell-arrow" @click="handleToEditInfo">
          <view class="menu-item-box">
            <view class="iconfont icon-user menu-icon"></view>
            <view>查看基础资料</view>
          </view>
        </view>
        <view class="list-cell list-cell-arrow" @click="handleHelp">
          <view class="menu-item-box">
            <view class="iconfont icon-help menu-icon"></view>
            <view>设置饮食偏好</view>
          </view>
        </view>
        <view class="list-cell list-cell-arrow" @click="handleAbout">
          <view class="menu-item-box">
            <view class="iconfont icon-aixin menu-icon"></view>
            <view>查看饮食记录</view>
          </view>
        </view>
        <view class="list-cell list-cell-arrow" @click="handleToSetting">
          <view class="menu-item-box">
            <view class="iconfont icon-setting menu-icon"></view>
            <view>账号管理</view>
          </view>
        </view>
      </view>

    </view>
  </view>
</template>

<script>
  import storage from '@/utils/storage'
  import {getUserProfile, updateUserProfile} from "@/api/system/user"
  
  export default {
    data() {
      return {
		  user: {
		    nickname: "",
		    phone: "",
		    sex: "",
		    disable: "",
		    activityIntensity: "",
		  },
		  sexs: [{
		    text: '男',
		    value: "0"
		  }, {
		    text: '女',
		    value: "1"
		  }],
		  onLoad() {
		    this.getUser()
		  },
        name: this.$store.state.user.name,
        version: getApp().globalData.config.appInfo.version
      }
    },
    computed: {
      avatar() {
        return this.$store.state.user.avatar
      },
      windowHeight() {
        return uni.getSystemInfoSync().windowHeight - 50
      }
    },
    methods: {
		getUser() {
		  getUserProfile().then(response => {
		    this.user = response.data
		  })
		},
		submit() {
		  updateUserProfile(this.user).then(response => {
		    this.$modal.msgSuccess("修改成功")
		  })
		},
      handleToInfo() {
        this.$tab.navigateTo('/pages/mine/info/index')
      },
      handleToEditInfo() {
        this.$tab.navigateTo('/pages/mine/info/edit')
      },
	  handlecollect(){
		  this.$tab.navigateTo('/pages/mine/collect/breakfest_all')
	  },
	  handlelike(){
	  		 this.$tab.navigateTo('/pages/mine/like/breakfest_all') 
	  },
	  handlehistory(){
	  	this.$tab.navigateTo('/pages/mine/history')	  
	  },
      handleToSetting() {
        this.$tab.navigateTo('/pages/mine/setting/index')
      },
      handleToLogin() {
        this.$tab.reLaunch('/pages/login')
      },
      handleToAvatar() {
        this.$tab.navigateTo('/pages/mine/avatar/index')
      },
      handleLogout() {
        this.$modal.confirm('确定注销并退出系统吗？').then(() => {
          this.$store.dispatch('LogOut').then(() => {
            this.$tab.reLaunch('/pages/index')
          })
        })
      },
      handleHelp() {
        this.$tab.navigateTo('/pages/mine/help/index')
      },
      handleAbout() {
        this.$tab.navigateTo('/pages/mine/about/index')
      },
    }
  }
</script>

<style lang="scss">
  page {
    background-color: #f5f6f7;
  }

  .mine-container {
    width: 100%;
    height: 100%;


    .header-section {
      padding: 15px 15px 45px 15px;
      background-color: #0084a4;
      color: white;

      .login-tip {
        font-size: 18px;
        margin-left: 10px;
      }
      .cu-avatar {
        border: 2px solid #eaeaea;

      }

      .user-info {
        margin-left: 15px;

        .u_title {
          font-size: 18px;
          line-height: 30px;
        }
      }
    }

    .content-section {
      position: relative;

      .mine-actions {
		 flex: 1;
        margin: 15px 15px;
        padding: 20px 0px;
        border-radius: 8px;
        background-color: #d8e8f1;
        .action-item {
			background-color: #d8e8f1;
                  flex: 1;
				  width: 100px;
				  height: 100px; 
                  margin: 0 5px;
				  padding:5px;
				  border: transparent;
        
        
                  .text {
                    display: block;
                    font-size: 12px;
                    margin: 8px 0px;
                  }
                }
      }
    }
  }
</style>
