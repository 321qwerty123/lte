import reqGlobal from '../reqGlobal';

/**
 * 测试nodejs 的mock接口
 * /goods/list
 */
export function testMockApi(){
    return reqGlobal.get('/goods/list');
}


export function loginReq(queryParamObj) {
    return reqGlobal.get('/lte/login',{params:queryParamObj});
}