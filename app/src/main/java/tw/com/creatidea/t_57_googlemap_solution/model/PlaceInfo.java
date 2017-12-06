package tw.com.creatidea.t_57_googlemap_solution.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by noel on 2017/12/6.
 */

public class PlaceInfo {

    /**
     * html_attributions : []
     * next_page_token : CqQCFQEAAKQrFMmCC1fD2040-8CFGf_zBvpTqpo_uW74Cg4LAbBCP8MaRFvMv5ucf3T7gpG432_JFAgSCM86Y_nKum_S49g7vOiPl1gwnr7VWlrtSAkjYCVmhRJbc9mNdTd2fDBFFzI5BFRMzLBu3PuplhBiJqRjwsUtkQX_22STL8p-kDn3k5AKHv3jS4lUkbY2ULkxvU_19GnIUmWMOb8j2DXskw5Nav-smr5iOSQ4oqqu5pB8NKIZLIFmi6mGi8Fbu8xhZ4CT43h0goLTifWVFDKDjPOqGs3t1Ry73ckHf0EeMzq5wBMYfkY3Kot-W9I-M8IaglBIjjpvApfLmQBhySBf0Bi4mq3UhnSjLZrIy0oVjc_9R-RR_L66r_jSFtQqMNs9kBIQnLEA8fkaeEyCfb54rmJ8XxoUOy6uDe-Z94cu9RF7zhbmarQO-DE
     * results : [{"geometry":{"location":{"lat":25.0522607,"lng":121.5211383},"viewport":{"northeast":{"lat":25.0537000302915,"lng":121.5225083802915},"southwest":{"lat":25.0510020697085,"lng":121.5198104197085}}},"icon":"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png","id":"8619a91656f1de919a9c29326d18c7d9139eeabd","name":"欣葉台菜","opening_hours":{"open_now":true,"weekday_text":[]},"photos":[{"height":1068,"html_attributions":[],"photo_reference":"CmRaAAAAXiDXZu64b7Ie4tl_BrDp3LNy6BevMrslv5N95UJrw-lzWTrurLjX4ot69hkaeEa8whmzjU3hHS4DWQfJwz04yXD3InhpAbTvVwklIiWyyXRPFlBGRAj2hnh_PuGkvr_zEhCpj7YJFOi5Czql-pREdy0YGhT43O6nJgSbpppkXw3T9Xucrv2ZfA","width":1600}],"place_id":"ChIJxQboPEWpQjQRNDguQnNV674","rating":3.8,"reference":"CmRSAAAAzMu5Yt88n8sRdd3YHRTC5E9p2r_Azr9jgA6FouatmOR3_qt6Zu3oqodc2T-AZu_JRXbmS6JlMHLDBt9FHZ9Ptihw5BOeERb9O0jP-xVQYWN9uSnAyHOAlay6HyrnF7s8EhAiUl0Voa7MHbfMMHiE9pSxGhRfS57Tohje2SSY7PJJPSgNj-aozQ","scope":"GOOGLE","types":["restaurant","food","point_of_interest","establishment"],"vicinity":"中山區南京西路12號8F"},{"geometry":{"location":{"lat":25.0505759,"lng":121.5221602},"viewport":{"northeast":{"lat":25.0519386802915,"lng":121.5234724802915},"southwest":{"lat":25.04924071970849,"lng":121.5207745197085}}},"icon":"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png","id":"6399b7d9defadbf9f608a16603c9e6927a07330f","name":"一風堂（中山本店）","opening_hours":{"open_now":true,"weekday_text":[]},"photos":[{"height":2448,"html_attributions":[],"photo_reference":"CmRaAAAA9ugpgq5xmqfWUoIrwJedaDccoulTDnq4NF8yfBOdhZ8DhBk-YsQxINXQPyCxCoDahdmXyA-MjMg-vpeuw_yYdEUSaiI2xcg3Q75wJBTdrIxArGlh0HWambBq6486sBQWEhAIJS3gnmEKyv4pWYBQihyXGhSiR6Hp_6jRpW4ixzaE3JAbkfLzvw","width":2448}],"place_id":"ChIJExxI5G6pQjQRvwxapNQ25QQ","rating":3.6,"reference":"CmRRAAAAVYKcZo3n7rHNnfhnalwftIBJHi-uBb1mXa5qkmsVSRV_pQno8A4oISW2H4QJpf_VNlo0DEP3oji9EfU7ZuOm7vMXkshaMJPJ1qJRsZbWu3NxTF5L5rIuM5C3Qo86wv2UEhAJpXdSaozGjpVL7BokoUeBGhTUit7DjFCxPSPG9HBDUh01EEJawA","scope":"GOOGLE","types":["restaurant","food","point_of_interest","establishment"],"vicinity":"中山區中山北路一段85號"},{"geometry":{"location":{"lat":25.0537149,"lng":121.520265},"viewport":{"northeast":{"lat":25.05506258029151,"lng":121.5216337802915},"southwest":{"lat":25.0523646197085,"lng":121.5189358197085}}},"icon":"https://maps.gstatic.com/mapfiles/place_api/icons/shopping-71.png","id":"d4d31db1e8a635e808d5380ec2b81d72f9c624de","name":"LA PASTA義大利麵屋","opening_hours":{"open_now":true,"weekday_text":[]},"photos":[{"height":3024,"html_attributions":[],"photo_reference":"CmRaAAAA5HjWQWVk28erm-COfCnZfaIvn5_Iy3EWkVTR8Oh1C6lmylOUdPMYH-9dqXCwOCKzh2OHXMvdY3-iVR45LddNDTEW1UcfNeOK8UlYxGIZKRPvIZdRxYwUP24EBXDpwb8TEhDUQ1h6aUKAvb9rkKhjXHiRGhQ7-riTAaUrxi9U6zusbRN2w08WRw","width":4032}],"place_id":"ChIJzScaXGmpQjQRke3bAIDOR8U","rating":3.3,"reference":"CmRSAAAAvFa9P3rpVZDKH7sMh492QpT-wuUX8hOANl2UqKDRimyLxX9dn90qorqS8_J4NyB_Z410pP_Hz3FlxMBulWRxohgeiXTA8gNfbOVVi5a6ef-mXg0WYuCt2K5Srl9asFGuEhArBPB6AaAHdvKopiemlpPJGhQimZG0J-wM7JrvcuBR1viurup_sA","scope":"GOOGLE","types":["restaurant","food","store","point_of_interest","establishment"],"vicinity":"大同區南京西路25巷4-3號"},{"geometry":{"location":{"lat":25.05202,"lng":121.519718},"viewport":{"northeast":{"lat":25.0533682802915,"lng":121.5210667802915},"southwest":{"lat":25.05067031970849,"lng":121.5183688197085}}},"icon":"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png","id":"0bc0246eaba8b8724ed190865917f86d6870c28e","name":"平成十九","opening_hours":{"open_now":true,"weekday_text":[]},"photos":[{"height":1824,"html_attributions":[],"photo_reference":"CmRaAAAAAl6jSM8XqQKTGabieya8wnM2zvXzdrEpJqF76PnQEFflrKrXitpNNuz3gZZugphw9caIYgKfGUtdJkE5aG_iCQokVJMlJ41zkyjYQmuYPa4g-1KgyPPjZl8E456Yq6H6EhCVGFZB_6hil3-hPru4bto4GhSCnWNU8DCL7Fu0DshP5L3JOkQQkQ","width":4191}],"place_id":"ChIJ23IAHWypQjQRbuPGXn5Q0lM","rating":4.1,"reference":"CmRRAAAAuzwYfW1viOpkZGREWgsyjtynKvLsCP4LgfW4XVHx7GZZKxJRz85hOaGWJQipKxBnDAQLPDs3MpXVse3JBFsHu46-Mxq9-BeQVgOlfyAi6F4a4phS9_YCGhmogEu8wrx9EhCsmTyeD7XRnxjK9odK8n6gGhQcKrlmWDfgTTzdKGvmiCfj29b1uQ","scope":"GOOGLE","types":["restaurant","food","point_of_interest","establishment"],"vicinity":"大同區南京西路18巷6弄8號"},{"geometry":{"location":{"lat":25.05396889999999,"lng":121.522847},"viewport":{"northeast":{"lat":25.0553193802915,"lng":121.5241566302915},"southwest":{"lat":25.0526214197085,"lng":121.5214586697085}}},"icon":"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png","id":"58dbed8b96473705afcb5c40328e87ac191ba2c7","name":"中山日本料理廳 - 台北老爺大酒店(2F)","opening_hours":{"open_now":true,"weekday_text":[]},"photos":[{"height":2988,"html_attributions":[],"photo_reference":"CmRaAAAA89laOCV8692dHIWe60zI0cBakdCUR-2o8lwMNIA0p5QTtzFCDN-QHNvvNeLc_NUeLgKhbfGFYRcI9O-7T1mLgW-2jFN3rrVE0Mw4taJ3k1nWoXk4_sX2mFNSmLuM3JdhEhATKxzSKQzDxXWlgo-AQC-TGhQYl7H4K0nsORTuE4ZnH0CMSnGJpA","width":5312}],"place_id":"ChIJu63D4mipQjQRtFjMT4CrBKc","rating":4,"reference":"CmRSAAAAgmAsiXqM4QC9w16A2oee70NEIY2ADxrC_4vG6arWKGPr5vNDsCtjR4dJ9zIzjct28JO2Fmq3BFCrsVBdxA15_BeERUloAhlz0irrngxVvEZyFMYbaZVkfcDUtwVh56q6EhCXTtPNlXNft0YsQ60n44GBGhQAWBgR2HDgjyxSOKuUtXhyBzn14A","scope":"GOOGLE","types":["restaurant","food","point_of_interest","establishment"],"vicinity":"中山區中山北路二段37之1號2F"},{"geometry":{"location":{"lat":25.05515,"lng":121.522484},"viewport":{"northeast":{"lat":25.0565703302915,"lng":121.5238828302915},"southwest":{"lat":25.0538723697085,"lng":121.5211848697085}}},"icon":"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png","id":"6c2bbc647d7837a1e2002cbd3908604d0a3c6dec","name":"夏慕尼新香榭鐵板燒台北中山北店","opening_hours":{"open_now":true,"weekday_text":[]},"photos":[{"height":2160,"html_attributions":[],"photo_reference":"CmRaAAAAivCOMPct1y9DMIqBoEj-_Lmf6_aSlRET9zHjwSHewDerdwHvM0mWZvTj0K142heZfDQXBI4kgtdbXcPIkU3_SdPupeMfep8Hrr7VvJTfqcQOi44UHY1ejNO_N4XwdInQEhDJrTkpsC3pBPHO2dwvyFTwGhTarSocEcLR9iiTo4l1MJj9fljJjw","width":2880}],"place_id":"ChIJf3pxrGmpQjQRX2eGPcFCreg","rating":4.3,"reference":"CmRSAAAA1SvZZ9iEEsuvINBfbvRgHup_zNSN-mpcrPc7DoQ5IdbkG9obdnKWGf3icjWZL9ykqRM68INiZSprRM0hRnn-1pQKhBeQ-6HQqDkhksrps13pfpmi00ML72mHwYLLEOnCEhBd34ANZGpcWa2B85j5AcTTGhQjOMsP4RqS5OoEoTiWZlc_ARZ2TA","scope":"GOOGLE","types":["restaurant","food","point_of_interest","establishment"],"vicinity":"中山區中山北路二段44號"},{"geometry":{"location":{"lat":25.05414399999999,"lng":121.522435},"viewport":{"northeast":{"lat":25.0554900302915,"lng":121.5238464302915},"southwest":{"lat":25.0527920697085,"lng":121.5211484697085}}},"icon":"https://maps.gstatic.com/mapfiles/place_api/icons/cafe-71.png","id":"9df01464f98ae2c80793453b8d235929e4302cde","name":"The One 中山","opening_hours":{"open_now":true,"weekday_text":[]},"photos":[{"height":3276,"html_attributions":[],"photo_reference":"CmRaAAAAYmnOQXFHhyT2dWF4y37cYrexQsddmysXshP6HWqMFoXTJzuRBlydTaHxBaNiDZr2WeyDBD1iJlDSNwtWe2PCeexK6B59L2Yj3GYjwRMpK5MEbekUCPnAHLCoXiYNr992EhBkv6Dt2tI3SMdIOqRsOIKuGhTyy3g8J7KPBHTPjv4d8tIUyNkCaQ","width":4949}],"place_id":"ChIJV5lMA2mpQjQR_rSsWRfFRuw","rating":4.1,"reference":"CmRSAAAAS15MxvbKnjBfd3nRKHrIVPL2JyVRwgJ5kqp3itpUwnwmF8L-_WoVvrPbYTH3pWL2OhDSiSmrL_UqfUmSmuMi19WOPCwbJMoStiXBIKre-QJq9BgtLj2k4x31L_58YIqBEhABmolAWk1PdAeOxLmaMewyGhS1Po4DfzHqRSeo-dmKx78u7I83nA","scope":"GOOGLE","types":["cafe","restaurant","food","museum","point_of_interest","establishment"],"vicinity":"中山區中山北路二段30號"},{"geometry":{"location":{"lat":25.0503314,"lng":121.519767},"viewport":{"northeast":{"lat":25.0516524302915,"lng":121.5211078802915},"southwest":{"lat":25.04895446970849,"lng":121.5184099197085}}},"icon":"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png","id":"f4eada123092f2791d4b0f32e7fb16ddc941925d","name":"Mushroom Forest 蘑菇森林義大利麵坊","opening_hours":{"open_now":true,"weekday_text":[]},"photos":[{"height":630,"html_attributions":[],"photo_reference":"CmRaAAAAFLH8Z7sVYr8upAURS2YES5OL1Uwgb1wnHgcZbZ5eJG_AKH1KB5LJFSJEZQZ9aQy3U9-5OdrJ7jwytehiHRU2c4XZBYPkVNmNxisz0qHjTbFn7SWRBNPTI3vtc1BV-uJSEhCLo9DrwkeIcIUWM-jnDCyvGhQ76RhLvgcg8ukPcaAdLWRS1kInsw","width":1200}],"place_id":"ChIJv3JcKmypQjQR5zeIcMxZgIc","rating":3.5,"reference":"CmRSAAAAdr-v72RZM28bReS2vmkGx5oIsc0vvkasmSLqIqmZksQuqOlVP7pJBDzOdREzAjc6PM8bWTXILY9LOERWZwE2DG2WD4MfAZBIwC_EoV1cE9S3kb9ZbgmKI7wOm1Ae8cqSEhC3tX0QgL70JHNX0DJWWhB6GhSedWlqqBozPGLoDzC6QEZ6gukAMA","scope":"GOOGLE","types":["restaurant","food","store","point_of_interest","establishment"],"vicinity":"大同區長安西路33號"},{"geometry":{"location":{"lat":25.057676,"lng":121.521362},"viewport":{"northeast":{"lat":25.0590599302915,"lng":121.5227057802915},"southwest":{"lat":25.0563619697085,"lng":121.5200078197085}}},"icon":"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png","id":"fb464d1aca48d1420a2ccb18f5cad65b66472103","name":"百八魚場 民生店","opening_hours":{"open_now":true,"weekday_text":[]},"photos":[{"height":471,"html_attributions":[],"photo_reference":"CmRaAAAARmHV715rQZgkzvsqPwp_mMsQ-YjS5w9Nz-xnP_6Hd6EE7QLbBF6LKD620mx8r2ochHbDoW_8Tfw1z1gNwkZoyD-6cszWKHe3amvnPW91Ahace5fao_ERZAiqOeWXbIAOEhDIvBcPJ9Fc89WyjPYkHZa6GhSvy-sSi40I-dETzVWw8VfWQdmMMg","width":940}],"place_id":"ChIJIRLB32mpQjQRXPO-64Ru9Z4","rating":3.9,"reference":"CmRSAAAAHsJazr22u_KWK9ViFPNBAYxpo7RrVPQPUDw-jMoA1HVDAE-XNfbZaXTz98XMjVd48b6LDn3PHf61G2lgLB2fiPyBi7uGPkMP-HznUJpHzUoEcl7u_mKHFQxikVr5asYYEhDYgrM3km2xBpCeKSO1A2spGhRQTe3-Lz0xuPGmhSZwYcZsF1YmSA","scope":"GOOGLE","types":["restaurant","food","point_of_interest","establishment"],"vicinity":"中山區民生西路44號"},{"geometry":{"location":{"lat":25.0528293,"lng":121.5237803},"viewport":{"northeast":{"lat":25.0541411302915,"lng":121.5251271802915},"southwest":{"lat":25.0514431697085,"lng":121.5224292197085}}},"icon":"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png","id":"9ec363b156f250fe0f8f19e35dc8cfe535b6a93a","name":"夢見哈比屯","opening_hours":{"open_now":true,"weekday_text":[]},"photos":[{"height":3024,"html_attributions":[],"photo_reference":"CmRaAAAAKmDzMKeNmLUg4SSsPqE5CB2zmIgZBUkRo6tuUajq4M224Z5HcxVLZ7fCq1RO8Y3C5AChkIlAlvgE-qp_mIZ5rpZAbdEiKJ8WJwP5drnAtGWEWu817CD2C0O8DY4lICZNEhAVuonS0YvtlEE75aI7iuTDGhSNuxzC1d_0Los4wr0uNSEJNRw1Yw","width":5376}],"place_id":"ChIJmUL_w2ipQjQRFc95R5cH0Ro","rating":2.8,"reference":"CmRRAAAAkKIliodIkXzr0Kb8wz23xHNuLdQunbTojqP1i59dFES_H6GhyB7cTK-q5WdyndcKUAtc7Nkx6fqTZgNHSPqpupKgxp_UHn7WMnrryoKKL957Bys2C51IpQ-EoDoZN0-kEhCnC8DA72tQxqCPnDwTaxRKGhTcuM9G3LajikJw87s0ZggQoeYHWQ","scope":"GOOGLE","types":["restaurant","food","point_of_interest","establishment"],"vicinity":"中山區中山北路二段11巷7之2號"},{"geometry":{"location":{"lat":25.0533068,"lng":121.5229189},"viewport":{"northeast":{"lat":25.0546057802915,"lng":121.5242661302915},"southwest":{"lat":25.0519078197085,"lng":121.5215681697085}}},"icon":"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png","id":"47305cada32374febc226d70cf79e7ff82a3b0d3","name":"王品牛排-中山北店","opening_hours":{"open_now":true,"weekday_text":[]},"photos":[{"height":1836,"html_attributions":[],"photo_reference":"CmRaAAAAoJ0o0rYatwiSdl7BHZqUqFAO_dZQC9PoKkl93WT0NI2vPAexXHMvXVDz1yNa9jiT6gr2fWNZ9rP7_JBX6fwYg7srMrjj6Cv0cipwz62IxJq7q0CXQDK8yi08Rv9njb5oEhDXAQMcEkJ9Atxdx5akMK33GhRGqsmKHPe8zCQqzOsJqKSQB2qo0A","width":3264}],"place_id":"ChIJVz_H32ipQjQRDDbDTPoI01Q","rating":4,"reference":"CmRRAAAAnFJAcSk2r7NBRv6BQIswuZH1b1n2cH77epB1Xk8okALMOFBE9z_akPk9KH33tySzIMmGWNKWMAVMK_7ENjwO_Ri8oq8WzkBHjv-nmuYwuyRnJqkxxzc_kNuyV_OqXnUoEhAI7_-p1Uf0V-FlEuFjmt4sGhRvLJIlv2brx-ncS6G9wdf7FInGyQ","scope":"GOOGLE","types":["restaurant","food","point_of_interest","establishment"],"vicinity":"中山區中山北路二段33號2樓"},{"geometry":{"location":{"lat":25.054187,"lng":121.52424},"viewport":{"northeast":{"lat":25.0555660302915,"lng":121.5249663},"southwest":{"lat":25.0528680697085,"lng":121.5220611}}},"icon":"https://maps.gstatic.com/mapfiles/place_api/icons/generic_business-71.png","id":"265eb71caca3bb0c1fa814426244514d6a4e8b5b","name":"台北晶華酒店- 柏麗廳 Brasserie","opening_hours":{"open_now":true,"weekday_text":[]},"photos":[{"height":1365,"html_attributions":[],"photo_reference":"CmRaAAAAixCaWy0PglM5jt1Fc69eiPa7E5zXF58nBMHqQQsA1xUTorMiqO1tyoXh7tLTXp1V_RX79KdHmSnLFLxgUsQITgzJzQqUkQr6mD-3zp-YJkHg0iC94vvCMROVdRMRd5szEhCz0tJ5eSfvI0TWbJSdTA-xGhT9QSlH_R2BhvdOQ-DwaLBLpTj9pQ","width":2048}],"place_id":"ChIJyQcF-WipQjQRWCGQsl0cNzI","rating":4.2,"reference":"CmRRAAAAdeT2eW6JJ6Ff_Ux4ZF_9QhMVUPGgxrVgTIdsThEulm8oxGdEyu4tkuI3E6IQgvTuWL2_uVC04dte14teaE4O7RZYaQ59wbm6A_DH6xdbD0fTreMXD-s2PncMoHWh237lEhBvNeG17TQnze0IN5mk28MqGhR9oQnIHV98I4vNQPAcafj8KRr1fQ","scope":"GOOGLE","types":["restaurant","food","point_of_interest","establishment"],"vicinity":"中山北路二段39巷3號1樓, 中山區"},{"geometry":{"location":{"lat":25.0538787,"lng":121.5229292},"viewport":{"northeast":{"lat":25.0552308802915,"lng":121.5241956802915},"southwest":{"lat":25.0525329197085,"lng":121.5214977197085}}},"icon":"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png","id":"c15b17ad2a4273dd22566bc2f92441c4854a0e9a","name":"老爺酒店Le Caf'e","opening_hours":{"open_now":true,"weekday_text":[]},"photos":[{"height":1200,"html_attributions":[],"photo_reference":"CmRaAAAAc90WeyvV1lOuqC7iVxdHkHEPna7nrcEI1QEErk8aBjhFpEzqC1o9ZwhsIvKjyfTMV5U7MhufQ_ziXsr0CD8E5M-vRruhF2xI0kdnPugktvfWWnCn47SXIzvSHXjIGs-BEhCtjp_71ZLpxsSLzMC-zTRPGhSmkUau6bNcObK0cUE1aiDMmovseg","width":1600}],"place_id":"ChIJu63D4mipQjQRRWbpB7bB_Rg","rating":4.1,"reference":"CmRRAAAA19l9Ind3D8xGsGF0kq-T7FK7QC7GlsXH61qTZItGbGZ0yUMatRxE-1rYeYe_IYwVBRFlp0O8dISLxf3uJrcqR9nQTj-qGKmwXW7XkcWNKO9xuIrpc-bE5rJ_-pDUG0USEhC-OtJ1tgmPCgVtnT4NG8aWGhT2UCsYTvNIY4dSTxvtd9kXHHRJUw","scope":"GOOGLE","types":["cafe","restaurant","food","point_of_interest","establishment"],"vicinity":"中山區中山北路二段37之1號2樓"},{"geometry":{"location":{"lat":25.0516826,"lng":121.5174428},"viewport":{"northeast":{"lat":25.0530436802915,"lng":121.5187406802915},"southwest":{"lat":25.0503457197085,"lng":121.5160427197085}}},"icon":"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png","id":"66bd4eb816166461f485bfccb8d8d9f6a2a01d3f","name":"提拉米蘇精緻蛋糕","opening_hours":{"open_now":true,"weekday_text":[]},"photos":[{"height":676,"html_attributions":[],"photo_reference":"CmRaAAAAxJAJrhSGxOyWxjevGt5WxUJLmBE_PTnyJ8x0xdJa76qVrLI7zPf9885PrvRXVCOhX_LYpeTh4GSyNvVcyZFVG4TslQqCABUEvEFtNkl38-UZAVjcMpBcSTJuqEms_HsaEhA5tSVNDCLaK99g4Yfx4p_cGhRHXoetoqCwDJySmcQUSLIuoUllLg","width":1202}],"place_id":"ChIJkdmKW2ypQjQRmS2zUex3Hmg","rating":4.4,"reference":"CmRRAAAAy0fUh01vZgC1p9f0RaR4ao1j5KoAuC8ugqZls_J52_Ug902pZmQiyYiUZV_W6Ooj9ruu-jfRye17dCQ7dmAKnpDU_gcFA5QZNTsODyKcJ1ODCWQ0mCXFljT9cCiKYkfZEhAQCNd8wiLpic5d2EiZ2LtxGhSegStoHR3VBGQwU7cYF3hTtv4V2g","scope":"GOOGLE","types":["bakery","food","store","point_of_interest","establishment"],"vicinity":"大同區承德路一段55號"},{"geometry":{"location":{"lat":25.0531829,"lng":121.5207406},"viewport":{"northeast":{"lat":25.0545261302915,"lng":121.5220890802915},"southwest":{"lat":25.0518281697085,"lng":121.5193911197085}}},"icon":"https://maps.gstatic.com/mapfiles/place_api/icons/cafe-71.png","id":"6c2735f27dae785fd8fc90e5b56be5c90113803c","name":"Jumane cafe","photos":[{"height":4032,"html_attributions":[],"photo_reference":"CmRaAAAABysqqR4Jss3NQVviHZZXL8YtxQk_0IeA1dDaA3bd-eYNxRjzFNvyPaXrgVsDzWN-18AphfuTKMp383FmVsrjzEZpMrkmgQbmJA_CfVIkFXoNOnH8MEl55smfQxpyYH1wEhArxtSlo3YPiJLD8nCVHNbmGhTauLT0p4T4da-3ANUKlT0D1-cMsw","width":3024}],"place_id":"ChIJKwJ-RWmpQjQRxJo3lQSCbl0","rating":3.7,"reference":"CmRRAAAA2y7KqzcCXIOMWekqFgXPvSx1pLtUhTboWK5ZJv9ICqcvXrRwZ0VmlHam2_KbEp8UpSHuItGMCAp3g_F4HsmjGnfF0JFyC2nghRfXgDqWndiJpznTsQoGIwtCPg6n0gE5EhBFb3Mt651oz2HPbcBVG_5-GhSF0nAJpnZWyQc6TEqO4alFLUgxfw","scope":"GOOGLE","types":["cafe","food","point_of_interest","establishment"],"vicinity":"中山區中山北路二段16巷25號"},{"geometry":{"location":{"lat":25.051345,"lng":121.516941},"viewport":{"northeast":{"lat":25.0526770302915,"lng":121.5183613302915},"southwest":{"lat":25.0499790697085,"lng":121.5156633697085}}},"icon":"https://maps.gstatic.com/mapfiles/place_api/icons/shopping-71.png","id":"3615fca418c1a212edf2005073d90fda14655ac6","name":"日多寶","opening_hours":{"open_now":true,"weekday_text":[]},"photos":[{"height":5304,"html_attributions":[],"photo_reference":"CmRaAAAANYx0VH3QWsKGLVLL6zkRvRKkJlj_6XojQTDzP_rE73PZot-RffzRC2TuothC3rcLpGBXcM1PXIhICza2z2vq0uDPkrEFj0ufsafK5JW3rDEdozGTmtA4btzQeBVmwQ8mEhBVfbvhKaBFMamoHgtD7rtHGhSHadH7jpWrc9p3XPYLbdFrWYYevw","width":7952}],"place_id":"ChIJcYQz9GupQjQRUqvpCj9G1Sc","rating":4.5,"reference":"CmRRAAAAKRlUnbKDshe0iwud0gJngJrTIckec1q_mIBbYMyIq7FIC3hI0IsDLsV0giSLHUeDIc5i_Q9VekgQWKDaWJ0aGlC8jmnim4mad0gqiKNn18dUlsmOp_SqHUkpmYf-B7IqEhBQrbmTVQl73iPQTuFgq6eaGhTXfcpnymO8HZpCiVd_XJLrZD8aYw","scope":"GOOGLE","types":["bakery","food","store","point_of_interest","establishment"],"vicinity":"大同區承德路一段44號"},{"geometry":{"location":{"lat":25.0549026,"lng":121.5203316},"viewport":{"northeast":{"lat":25.0562305302915,"lng":121.5216792802915},"southwest":{"lat":25.05353256970849,"lng":121.5189813197085}}},"icon":"https://maps.gstatic.com/mapfiles/place_api/icons/cafe-71.png","id":"ef7253ab7526e2c6761c538b2129bf48da73c15b","name":"（百花台）R9 Café","opening_hours":{"open_now":true,"weekday_text":[]},"photos":[{"height":2832,"html_attributions":[],"photo_reference":"CmRaAAAAL5xIgjA8aHM2yCgf6jDd4H4_Vh2AvmB3z07E7h1FaXE7J6Z5jWEBZRy-En_tQ6mKcF8XE4urUQOSyqz8e7u4AZU1CC5z6sYw7u3fHY1HlEIR-l_HN3aKuzSZ6gLQ6NI_EhDKfBBCEd-0EVGySAKkmL8oGhRJ54dfW6i4NdIehsVLnHeDZ_-_FA","width":4256}],"place_id":"ChIJ57Tqe2mpQjQRYJHQgz16IVw","rating":3.6,"reference":"CmRRAAAAGBnSEoGy-qaavYrT8NZYxdn9krFTZ0L_IHr1o5-QvJbHAlgq1BtRgb19kgS1Fx5DGDWAFItxkh-RUYFfS48_TEW8HhhAbfJ2XVIyTXKuZF4CZEYR0WulJbbGS9UXBCFFEhAqLY6umWQykbLsIr3EVZ4-GhRnnH706ZfOxFmGKtNMASMJqHJzkQ","scope":"GOOGLE","types":["cafe","restaurant","food","point_of_interest","establishment"],"vicinity":"大同區赤峰街41巷13號"},{"geometry":{"location":{"lat":25.054309,"lng":121.523772},"viewport":{"northeast":{"lat":25.0554881802915,"lng":121.5251116802915},"southwest":{"lat":25.05279021970849,"lng":121.5224137197085}}},"icon":"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png","id":"a1c3774e874b50e7e98f5c2854ba84ad5e8b64f1","name":"azie廳","opening_hours":{"open_now":true,"weekday_text":[]},"photos":[{"height":3024,"html_attributions":[],"photo_reference":"CmRaAAAAe4rHJpNh9QTEelRpyrbT7zDxn7viKuzoWfJjGA1FSp83o6PZEPxdtDQ0xNF9vG8gs9lfCWMtvhvimJN7S4oTCxprOJrmQ3FtOIT-FkhwQihQat-bz7T_vmUZjNbJhhWoEhDyqBpyfNw4yH8dzDtPtWBeGhSvVYUDZgUThzYu3DqSyBIzW2m1aw","width":4032}],"place_id":"ChIJ59mG9mipQjQRHtX7LvCwcTA","rating":4,"reference":"CmRRAAAAHXveHwARtcuylRpPCJtWQGXnwLJ4TzIB4kWN640jEpmK0dlE_0TevmE6180-uspeI4OB5nLK28FxUGmRRhlfjyWtvMJt24K7t_Rm2EUjcMAKugN0XUCa4mzXX0amAy0_EhA-A2u9v_YXFPCY2v5YkgAzGhRIqWArJuPcVKeuOtjMiu3Igsc0HQ","scope":"GOOGLE","types":["restaurant","food","point_of_interest","establishment"],"vicinity":"中山區中山北路二段39巷3號"},{"geometry":{"location":{"lat":25.0524956,"lng":121.5219216},"viewport":{"northeast":{"lat":25.0538027802915,"lng":121.5232611802915},"southwest":{"lat":25.0511048197085,"lng":121.5205632197085}}},"icon":"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png","id":"bdd2d8ad79ce66a327ee026861183d3f0fd280bb","name":"天廚菜館 烤鴨","opening_hours":{"open_now":true,"weekday_text":[]},"photos":[{"height":3024,"html_attributions":[],"photo_reference":"CmRaAAAAs50yAYIrPZhYP7m73RI8KaBRDxzHPRfI8YLCibLQTchaKlTe8tAEhzeUAxT2Iw51lftypLo0MEeYgjmGJglRGVndWA46IWgbthvfzjwRfwXkdI4QmxTJsSNEBs-UpeqEEhAfCaK9ODteij08WQj595iNGhRRhkm6IQE49iItVkrGBv1pMeg-gw","width":4032}],"place_id":"ChIJkcqlLWmpQjQRDcUKewBR3Sc","rating":3.8,"reference":"CmRRAAAAxplU06hsagi8aV_Z01dlhqLSbL5VM5hjNOcd2Ra2-M0Uapym4e7BdQgf0tAEFfjrn1mTeiTFlobvapfiIT_3CEJKQfM6SSdNsx_3dPK76Sk4_zdcMku9b70Ksm1ZuwMtEhAshcTPyQgJdUOQLGZRvQLrGhR7AyskhImqdG67boE4NVn9_h0_gw","scope":"GOOGLE","types":["restaurant","food","point_of_interest","establishment"],"vicinity":"中山區南京西路1號3樓"},{"geometry":{"location":{"lat":25.0541874,"lng":121.52424},"viewport":{"northeast":{"lat":25.0554273802915,"lng":121.5253462302915},"southwest":{"lat":25.0527294197085,"lng":121.5226482697085}}},"icon":"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png","id":"823f6d3f8bee82746a97b9edf34b2a50367b5d59","name":"台北晶華酒店- 三燔本家 Mihan Honke","opening_hours":{"open_now":true,"weekday_text":[]},"photos":[{"height":1333,"html_attributions":[],"photo_reference":"CmRaAAAAH8AkcE2xLRZMqEpsD_6S6Hyj-B6g67PwpPwkggPZqRTD631vJv730sZMbLuFnyexN1BUDiuxzqhorBCi0vsb6GiMw1Y5OIEP8aX4PDhD74DCiKNPSON6vBwd5Nhv9JI8EhAnPxoFpLLGmCKLjKM2lNv3GhQTKAwRfgVVv-SARpy52xYytUkaBA","width":2000}],"place_id":"ChIJ5ymH9mipQjQR4cmqOqlu9xE","rating":3.8,"reference":"CmRRAAAAlGp47OH97bTHb3jiANAF5dKnj3vM4o3bdKVqQGhLrrgY56McKU0HuBSu8RnmJGnXWyDhbgsAEo4GnSBnP3QN662D3ll9NSDlmvIGJSJ68pkhQMJ30yXHFY_XDBMni_6OEhDHA3kxNtpfWcGa7vxYQnNdGhTVjoowwTgdYYpkUspznPqyvVkkjg","scope":"GOOGLE","types":["restaurant","food","point_of_interest","establishment"],"vicinity":"中山北路二段39巷3號B3樓, 中山區"}]
     * status : OK
     */

    @SerializedName("next_page_token")
    private String nextPageToken;
    @SerializedName("status")
    private String status;
    @SerializedName("html_attributions")
    private ArrayList<?> htmlAttributions;
    @SerializedName("results")
    private ArrayList<ResultsBean> results;

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<?> getHtmlAttributions() {
        return htmlAttributions;
    }

    public void setHtmlAttributions(ArrayList<?> htmlAttributions) {
        this.htmlAttributions = htmlAttributions;
    }

    public ArrayList<ResultsBean> getResults() {
        return results;
    }

    public void setResults(ArrayList<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * geometry : {"location":{"lat":25.0522607,"lng":121.5211383},"viewport":{"northeast":{"lat":25.0537000302915,"lng":121.5225083802915},"southwest":{"lat":25.0510020697085,"lng":121.5198104197085}}}
         * icon : https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png
         * id : 8619a91656f1de919a9c29326d18c7d9139eeabd
         * name : 欣葉台菜
         * opening_hours : {"open_now":true,"weekday_text":[]}
         * photos : [{"height":1068,"html_attributions":[],"photo_reference":"CmRaAAAAXiDXZu64b7Ie4tl_BrDp3LNy6BevMrslv5N95UJrw-lzWTrurLjX4ot69hkaeEa8whmzjU3hHS4DWQfJwz04yXD3InhpAbTvVwklIiWyyXRPFlBGRAj2hnh_PuGkvr_zEhCpj7YJFOi5Czql-pREdy0YGhT43O6nJgSbpppkXw3T9Xucrv2ZfA","width":1600}]
         * place_id : ChIJxQboPEWpQjQRNDguQnNV674
         * rating : 3.8
         * reference : CmRSAAAAzMu5Yt88n8sRdd3YHRTC5E9p2r_Azr9jgA6FouatmOR3_qt6Zu3oqodc2T-AZu_JRXbmS6JlMHLDBt9FHZ9Ptihw5BOeERb9O0jP-xVQYWN9uSnAyHOAlay6HyrnF7s8EhAiUl0Voa7MHbfMMHiE9pSxGhRfS57Tohje2SSY7PJJPSgNj-aozQ
         * scope : GOOGLE
         * types : ["restaurant","food","point_of_interest","establishment"]
         * vicinity : 中山區南京西路12號8F
         */

        @SerializedName("geometry")
        private GeometryBean geometry;
        @SerializedName("icon")
        private String icon;
        @SerializedName("id")
        private String id;
        @SerializedName("name")
        private String name;
        @SerializedName("opening_hours")
        private OpeningHoursBean openingHours;
        @SerializedName("place_id")
        private String placeId;
        @SerializedName("rating")
        private double rating;
        @SerializedName("reference")
        private String reference;
        @SerializedName("scope")
        private String scope;
        @SerializedName("vicinity")
        private String vicinity;
        @SerializedName("photos")
        private ArrayList<PhotosBean> photos;
        @SerializedName("types")
        private ArrayList<String> types;

        public GeometryBean getGeometry() {
            return geometry;
        }

        public void setGeometry(GeometryBean geometry) {
            this.geometry = geometry;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public OpeningHoursBean getOpeningHours() {
            return openingHours;
        }

        public void setOpeningHours(OpeningHoursBean openingHours) {
            this.openingHours = openingHours;
        }

        public String getPlaceId() {
            return placeId;
        }

        public void setPlaceId(String placeId) {
            this.placeId = placeId;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public String getReference() {
            return reference;
        }

        public void setReference(String reference) {
            this.reference = reference;
        }

        public String getScope() {
            return scope;
        }

        public void setScope(String scope) {
            this.scope = scope;
        }

        public String getVicinity() {
            return vicinity;
        }

        public void setVicinity(String vicinity) {
            this.vicinity = vicinity;
        }

        public ArrayList<PhotosBean> getPhotos() {
            return photos;
        }

        public void setPhotos(ArrayList<PhotosBean> photos) {
            this.photos = photos;
        }

        public ArrayList<String> getTypes() {
            return types;
        }

        public void setTypes(ArrayList<String> types) {
            this.types = types;
        }

        public static class GeometryBean {
            /**
             * location : {"lat":25.0522607,"lng":121.5211383}
             * viewport : {"northeast":{"lat":25.0537000302915,"lng":121.5225083802915},"southwest":{"lat":25.0510020697085,"lng":121.5198104197085}}
             */

            @SerializedName("location")
            private LocationBean location;
            @SerializedName("viewport")
            private ViewportBean viewport;

            public LocationBean getLocation() {
                return location;
            }

            public void setLocation(LocationBean location) {
                this.location = location;
            }

            public ViewportBean getViewport() {
                return viewport;
            }

            public void setViewport(ViewportBean viewport) {
                this.viewport = viewport;
            }

            public static class LocationBean {
                /**
                 * lat : 25.0522607
                 * lng : 121.5211383
                 */

                @SerializedName("lat")
                private double lat;
                @SerializedName("lng")
                private double lng;

                public double getLat() {
                    return lat;
                }

                public void setLat(double lat) {
                    this.lat = lat;
                }

                public double getLng() {
                    return lng;
                }

                public void setLng(double lng) {
                    this.lng = lng;
                }
            }

            public static class ViewportBean {
                /**
                 * northeast : {"lat":25.0537000302915,"lng":121.5225083802915}
                 * southwest : {"lat":25.0510020697085,"lng":121.5198104197085}
                 */

                @SerializedName("northeast")
                private NortheastBean northeast;
                @SerializedName("southwest")
                private SouthwestBean southwest;

                public NortheastBean getNortheast() {
                    return northeast;
                }

                public void setNortheast(NortheastBean northeast) {
                    this.northeast = northeast;
                }

                public SouthwestBean getSouthwest() {
                    return southwest;
                }

                public void setSouthwest(SouthwestBean southwest) {
                    this.southwest = southwest;
                }

                public static class NortheastBean {
                    /**
                     * lat : 25.0537000302915
                     * lng : 121.5225083802915
                     */

                    @SerializedName("lat")
                    private double lat;
                    @SerializedName("lng")
                    private double lng;

                    public double getLat() {
                        return lat;
                    }

                    public void setLat(double lat) {
                        this.lat = lat;
                    }

                    public double getLng() {
                        return lng;
                    }

                    public void setLng(double lng) {
                        this.lng = lng;
                    }
                }

                public static class SouthwestBean {
                    /**
                     * lat : 25.0510020697085
                     * lng : 121.5198104197085
                     */

                    @SerializedName("lat")
                    private double lat;
                    @SerializedName("lng")
                    private double lng;

                    public double getLat() {
                        return lat;
                    }

                    public void setLat(double lat) {
                        this.lat = lat;
                    }

                    public double getLng() {
                        return lng;
                    }

                    public void setLng(double lng) {
                        this.lng = lng;
                    }
                }
            }
        }

        public static class OpeningHoursBean {
            /**
             * open_now : true
             * weekday_text : []
             */

            @SerializedName("open_now")
            private boolean openNow;
            @SerializedName("weekday_text")
            private ArrayList<?> weekdayText;

            public boolean isOpenNow() {
                return openNow;
            }

            public void setOpenNow(boolean openNow) {
                this.openNow = openNow;
            }

            public ArrayList<?> getWeekdayText() {
                return weekdayText;
            }

            public void setWeekdayText(ArrayList<?> weekdayText) {
                this.weekdayText = weekdayText;
            }
        }

        public static class PhotosBean {
            /**
             * height : 1068
             * html_attributions : []
             * photo_reference : CmRaAAAAXiDXZu64b7Ie4tl_BrDp3LNy6BevMrslv5N95UJrw-lzWTrurLjX4ot69hkaeEa8whmzjU3hHS4DWQfJwz04yXD3InhpAbTvVwklIiWyyXRPFlBGRAj2hnh_PuGkvr_zEhCpj7YJFOi5Czql-pREdy0YGhT43O6nJgSbpppkXw3T9Xucrv2ZfA
             * width : 1600
             */

            @SerializedName("height")
            private int height;
            @SerializedName("photo_reference")
            private String photoReference;
            @SerializedName("width")
            private int width;
            @SerializedName("html_attributions")
            private ArrayList<?> htmlAttributions;

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public String getPhotoReference() {
                return photoReference;
            }

            public void setPhotoReference(String photoReference) {
                this.photoReference = photoReference;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public ArrayList<?> getHtmlAttributions() {
                return htmlAttributions;
            }

            public void setHtmlAttributions(ArrayList<?> htmlAttributions) {
                this.htmlAttributions = htmlAttributions;
            }
        }
    }
}
