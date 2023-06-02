import request from '@/utils/request'

// 查询提示词种类列表
export function listCategory(query) {
  return request({
    url: '/chat/category/list',
    method: 'get',
    params: query
  })
}

// 查询提示词种类详细
export function getCategory(id) {
  return request({
    url: '/chat/category/' + id,
    method: 'get'
  })
}

// 新增提示词种类
export function addCategory(data) {
  return request({
    url: '/chat/category',
    method: 'post',
    data: data
  })
}

// 修改提示词种类
export function updateCategory(data) {
  return request({
    url: '/chat/category',
    method: 'put',
    data: data
  })
}

// 删除提示词种类
export function delCategory(id) {
  return request({
    url: '/chat/category/' + id,
    method: 'delete'
  })
}
