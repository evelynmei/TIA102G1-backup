import {createApp, computed, ref} from 'https://unpkg.com/vue@3/dist/vue.esm-browser.js';

import Axios from 'https://unpkg.com/axios@1.7.2/dist/esm/axios.min.js';

createApp({
    setup() {


        // 商品假資料
        const item = {
            checked: false,
            picture: "圖片",
            productName: "巧克力餅乾",
            price: 100,
            proAmount: 1,
            // total: this.price * this.proAmount
        };
        const itemTwo = {
            checked: false,
            picture: "圖片",
            productName: "牛奶糖餅乾",
            price: 200,
            proAmount: 2,
            // total: this.price * this.proAmount
        };
        const itemThree = {
            checked: false,
            picture: "圖片",
            productName: "白巧克力餅乾",
            price: 300,
            proAmount: 3,
            // total: this.price * this.proAmount
        };
        const items = ref([item, itemTwo, itemThree]);

        //計算屬性: 為使前端頁面更新計算結果, 需使用computed()

        const productNames = {
            1002: "巧克力餅乾",
            1004: "牛奶餅乾"
        };

        // const items = computed(() => {
        //     let items = [];
        //
        //     const getAxios = async () => {
        //         await Axios.get("http://localhost:8080/cart/1")
        //             .then(res => {
        //                 console.log(res.data);
        //                 items = res.data;
        //             })
        //             // .then(res => resData.value = res.data)
        //             .catch(error => console.log(error, "失敗"));
        //     };
        //     getAxios();
        //
        //     items.forEach(item => console.log(item));
        //
        //     items.forEach(item => item.productName = productNames[item.productId]);
        //     items.forEach(item => item.price = 300);
        //
        //     items.forEach(item => console.log(item));
        //     return items;
        // })


        const sum = computed(() => {
            let sum = 0;
            for (let i = 0; i < items.value.length; i++) {
                const subTotal = items.value[i].price * items.value[i].proAmount;
                sum = sum + subTotal;
            }
            return sum;
        })

        //刪除商品
        const deleteItem = () => {
        };

        return {

            items,
            sum,
            deleteItem
        }
    }
}).mount('#shopping-cart');
