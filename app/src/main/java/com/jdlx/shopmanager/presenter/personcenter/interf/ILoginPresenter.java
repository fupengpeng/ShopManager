package com.jdlx.shopmanager.presenter.personcenter.interf;

/**
 * @class_name: ILoginPresenter
 * @Description: 登录主导器接口
 * @Company: 山东九点连线信息技术有限公司
 * @ProjectName: com.jdlx.shopmanager.presenter.personcenter.interf
 * @author fupengpeng
 * @date 2017/11/30 0030 9:09
 */
public interface ILoginPresenter {
    /**
     * 登录
     *
     * @param account  账号
     * @param password 密码
     */
    void login(String account, String password);
}
