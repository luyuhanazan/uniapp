<template>
  <view class="container">
    <view class="example">
      <uni-forms ref="form" :model="user" labelWidth="80px">
        <uni-forms-item label="用户昵称" name="nickname">
          <uni-easyinput v-model="user.nickname" placeholder="请输入昵称"/>
        </uni-forms-item>
        <uni-forms-item label="手机号码" name="phone">
          <uni-easyinput v-model="user.phone" placeholder="请输入手机号码"/>
        </uni-forms-item>
        <uni-forms-item label="性别" name="sex" required>
          <uni-data-checkbox v-model="user.sex" :localdata="sexs"/>
        </uni-forms-item>
        <uni-forms-item label="身高(米)" name="height">
          <uni-easyinput v-model="user.height" placeholder="请输入身高"/>
        </uni-forms-item>
        <uni-forms-item label="体重(千克)" name="weight">
          <uni-easyinput v-model="user.weight" placeholder="请输入体重"/>
        </uni-forms-item>
		<uni-forms-item label="BMI" name="bmi">
			<span>您的BMI为</span>
		        <span>{{ getBMIStatus.bmi }}</span>
				<span>&nbsp;&nbsp;</span>
				<span>属于</span>
		        <span>{{ getBMIStatus.status }}</span>
		</uni-forms-item>
		<uni-forms-item label="慢性肾脏病分期(GFR值)" name="gfrValue" >
		  <uni-data-checkbox class="gfr-checkbox" v-model="user.gfrValue" :localdata="gfrValue"/>
		</uni-forms-item>

        <uni-forms-item label="过敏史" name="allergy">
          <uni-easyinput v-model="user.allergy" placeholder="请输入过敏史"/>
        </uni-forms-item>
		<uni-forms-item label="活动强度" name="activityIntensity">
		  <uni-data-checkbox v-model="user.activityIntensity" :localdata="activityIntensity" />
		</uni-forms-item>
		<uni-forms-item label="透析状态" name="dialysisStatus">
		  <uni-data-checkbox v-model="user.dialysisStatus" :localdata="dialysisStatus" />
		</uni-forms-item>
	<uni-forms-item label="并发症情况" name="complications">
	  <uni-data-checkbox v-model="user.complications" :localdata="complications" @change="handleComplicationsChange"/>
	</uni-forms-item>
		<uni-forms-item v-if="user.complications === '其他'" label="其他并发症" name="otherComplication">
		  <uni-easyinput v-model="user.otherComplication" placeholder="请输入其他并发症"/>
		</uni-forms-item>

		
      </uni-forms>
      <button type="primary" @click="submit">提交</button>
	  
    </view>
  </view>
</template>

<script>
import {getUserProfile, updateUserProfile} from "@/api/system/user"

export default {
  data() {
    return {
		imgList: [],
      user: {
        nickname: "",
		complications:"",
        phone: "",
        sex: "",
        disable: "",
        activityIntensity: "",
		height:"",
		weight:"",
		otherComplication: "",
		dialysisStatus:"",
      },
      sexs: [{
        text: '男',
        value: "0"
      }, {
        text: '女',
        value: "1"
      }],
	  gfrValue:[{
		  text: '1',
		  value:"1"
	  },{
		  text: '2',
		  value:"2"
	  },{
		  text: '3',
		  value:"3"
	  },{
		  text: '4',
		  value:"4"
	  },{
		  text: '5',
		  value:"5"
	  }],
	  complications:[{
		  text:'糖尿病',
		  value:"糖尿病"
	  },{
		  text:'高血压',
		  value:"高血压"
	  },{
		  text:'其他',
		  value:"其他"
	  }],
	  dialysisStatus:[{
		  text:"否",
		  value:"否"
	  },
	  {
		  text:"血液透析",
		  value:"血液透析"
	  },{
		  text:"腹膜透析",
		  value:"腹膜透析"
	  },],
	  activityIntensity:[{
		  text:"轻度",
		  value:"轻度"
	  },{
		  text:"中度",
		  value:"中度"
	  },{
		  text:"重度",
		  value:"重度"
	  },]
    }
  },
  onLoad() {
    this.getUser()
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
	ChooseImage() {
		uni.chooseImage({
			count: 4, //默认9
			sizeType: ['original', 'compressed'], //可以指定是原图还是压缩图，默认二者都有
			sourceType: ['album'], //从相册选择
			success: (res) => {
				if (this.imgList.length != 0) {
					this.imgList = this.imgList.concat(res.tempFilePaths)
				} else {
					this.imgList = res.tempFilePaths
				}
			}
		});
	},
	ViewImage(e) {
		uni.previewImage({
			urls: this.imgList,
			current: e.currentTarget.dataset.url
		});
	},
	DelImg(e) {
		uni.showModal({
			title: '召唤师',
			content: '确定要删除这段回忆吗？',
			cancelText: '再看看',
			confirmText: '再见',
			success: res => {
				if (res.confirm) {
					this.imgList.splice(e.currentTarget.dataset.index, 1)
				}
			}
		})
	},
  },
  computed: {
    // 计算属性，根据身高和体重计算BMI，并返回相应的提示信息
    getBMIStatus() {
          const height = parseFloat(this.user.height); // 身高（单位：米）
          const weight = parseFloat(this.user.weight); // 体重（单位：千克）
          let status = "";
          let bmi = "";
          if (!isNaN(height) && !isNaN(weight) && height > 0 && weight > 0) {
            bmi = (weight / (height * height)).toFixed(2); // 计算并保留两位小数的BMI值
            if (bmi < 18.5) {
              status = "偏瘦";
            } else if (bmi >= 18.5 && bmi < 24) {
              status = "正常";
            } else if (bmi >= 24 && bmi < 28) {
              status = "偏重";
            } else {
              status = "超重";
            }
          } else {
            status = "请输入有效的身高和体重";
          }
          return { bmi, status };
        }
      
  },
}
</script>

<style lang="scss">
page {
  background-color: #ffffff;
}

.example {
  padding: 15px;
  background-color: #fff;
}

.segmented-control {
  margin-bottom: 15px;
}

.button-group {
  margin-top: 15px;
  display: flex;
  justify-content: space-around;
}

.form-item {
  display: flex;
  align-items: center;
  flex: 1;
}

.gfr-checkbox .uni-list-item__text {
  font-size: 14px; /* 设置字体大小 */
}

.button {
  display: flex;
  align-items: center;
  height: 35px;
  line-height: 35px;
  margin-left: 10px;
}
</style>

