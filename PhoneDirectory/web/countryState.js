var countryStates = Object();
            
countryStates['China'] = '|Beijing|Anhui|Chongqing|Fujian|Gansu|Guangdong|Guangxi|Guizhou|Hainan|Hebei|Heilongjiang|Henan|Hubei|Hunan|Jiangsu|Jiangxi|Jilin|Liaoning|Nei Mongol|Ningxia|Qinghai|Shaanxi|Shandong|Shanghai|Shanxi|Sichuan|Tianjin|Xinjiang|Xizang (Tibet)|Yunnan|Zhejiang';
countryStates['India'] = '|New Delhi|Andaman/Nicobar Islands|Andhra Pradesh|Arunachal Pradesh|Assam|Bihar|Chandigarh|Chhattisgarh|Dadra/Nagar Haveli|Daman/Diu|Goa|Gujarat|Haryana|Himachal Pradesh|Jammu/Kashmir|Jharkhand|Karnataka|Kerala|Lakshadweep|Madhya Pradesh|Maharashtra|Manipur|Meghalaya|Mizoram|Nagaland|Orissa|Pondicherry|Punjab|Rajasthan|Sikkim|Tamil Nadu|Tripura|Uttaranchal|Uttar Pradesh|West Bengal';
countryStates['Japan'] = '|Tokyo|Aichi|Akita|Aomori|Chiba|Ehime|Fukui|Fukuoka|Fukushima|Gifu|Gumma|Hiroshima|Hokkaido|Hyogo|Ibaraki|Ishikawa|Iwate|Kagawa|Kagoshima|Kanagawa|Kochi|Kumamoto|Kyoto|Mie|Miyagi|Miyazaki|Nagano|Nagasaki|Nara|Niigata|Oita|Okayama|Okinawa|Osaka|Saga|Saitama|Shiga|Shimane|Shizuoka|Tochigi|Tokushima|Tokyo|Tottori|Toyama|Wakayama|Yamagata|Yamaguchi|Yamanashi';
countryStates['Malaysia'] = '|Kuala Lumpur|Johor|Kedah|Kelantan|Labuan|Melaka|Negeri Sembilan|Pahang|Perak|Perlis|Pulau Pinang|Putrajaya|Sabah|Sarawak|Selangor|Terengganu|Wilayah Persekutuan';
countryStates['SriLanka'] = '|Colombo|Central|North Central|Northern|Eastern|North Western|Sabaragamuwa|Southern|Uva|Western';

function setState()
{       
    var countryStateArr;
    countryStateSel=document.getElementById("state");
    countryStateSel.length = 0;
    countrySel=document.getElementById("country");
    var country = countrySel.options[countrySel.selectedIndex].value;
    if (countryStates[country])
    {
        countryStateSel.disabled = false;
        countryStateSel.options[0] = new Option('Select state','');
        countryStateArr = countryStates[country].split('|');
        for (var i = 0; i < countryStateArr.length; i++){
            countryStateSel.options[i+1] = new Option(countryStateArr[i],countryStateArr[i]);
        }
    }
    else countryStateSel.disabled = true;
}
function setNewState()
{
    var countryStateArr;
    countryStateSel=document.getElementById("stateChange");
    countryStateSel.length = 0;
    countrySel=document.getElementById("countryChange");
    if(countrySel.length>5){
        countrySel.remove(0);
    }
    var country = countrySel.options[countrySel.selectedIndex].value;
    if (countryStates[country])
    {
        countryStateSel.disabled = false;
        countryStateSel.options[0] = new Option('Select state','');
        countryStateArr = countryStates[country].split('|');
        for (var i = 0; i < countryStateArr.length; i++){
            countryStateSel.options[i+1] = new Option(countryStateArr[i],countryStateArr[i]);
        }
    }
    else countryStateSel.disabled = true;
}