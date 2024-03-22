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
        <uni-forms-item label="身高" name="height">
          <uni-easyinput v-model="user.height" placeholder="请输入身高"/>
        </uni-forms-item>
        <uni-forms-item label="体重" name="weight">
          <uni-easyinput v-model="user.weight" placeholder="请输入体重"/>
        </uni-forms-item>
        <uni-forms-item label="慢性肾脏病分期(GFR值)" name="gfrValue">
          <uni-easyinput v-model="user.gfrValue" placeholder="请输入慢性肾脏病分期(GFR值)"/>
        </uni-forms-item>
        <uni-forms-item label="活动强度" name="activityIntensity">
          <uni-easyinput v-model="user.activityIntensity" placeholder="请输入活动强度"/>
        </uni-forms-item>
        <uni-forms-item label="并发症情况" name="complications">
          <uni-easyinput v-model="user.complications" placeholder="请输入并发症情况"/>
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
    }
  }
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

.button {
  display: flex;
  align-items: center;
  height: 35px;
  line-height: 35px;
  margin-left: 10px;
}
</style>