import request from '@/utils/request'

// 用户密码重置
export function updateUserPwd(data) {
  return request({
    url: '/user/updatePassword',
    method: 'get',
    data
  })
}

// 查询用户个人信息
export function getUserProfile() {
  return request({
    url: '/user',
    method: 'get'
  })
}

// 修改用户个人信息
export function updateUserProfile(data) {
  return request({
    url: '/user',
    method: 'put',
    data
  })
}

// 用户头像上传
export function uploadAvatar(data) {
  return upload({
    url: '/system/user/profile/avatar',
    name: data.name,
    filePath: data.filePath
  })
}



// 设置饮食偏好
export function setDiet(data) {
  return request({
    url: '/user/setDiet',
    method: 'get',
    data
  })
}


// 用户注册接口
export function register(data) {
  return request({
    url: '/user/register',
    method: 'post',
    data
  });
}

export function getCodeImg() {
  return request({
    'url': '/captchaImage',
    headers: {
      isToken: false
    },
    method: 'get',
    timeout: 20000
  })
}
