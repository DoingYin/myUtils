package com.walloce.utils.imgConvert;

import java.io.*;

public class ImgConvert {
    /**
     * 将接收的字符串转换成图片保存
     * @param imgStr 二进制流转换的字符串
     * @param imgPath 图片的保存路径
     * @param imgName 图片的名称
     * @return
     *      1：保存正常
     *      0：保存失败
     */
    public static int saveToImgByStr(String imgStr,String imgPath,String imgName){
        System.out.println("二进制字符串开始转换为图片...");
        int stateInt = 1;
        if(imgStr != null && imgStr.length() > 0){
            try {
                // 将字符串转换成二进制，用于显示图片
                // 将上面生成的图片格式字符串 imgStr，还原成图片显示
                byte[] imgByte = hex2byte( imgStr );
                InputStream in = new ByteArrayInputStream(imgByte);
                //可以是任何图片格式.jpg,.png等
                File file=new File(imgPath,imgName);
                FileOutputStream fos=new FileOutputStream(file);
                byte[] b = new byte[1024];
                int nRead = 0;
                while ((nRead = in.read(b)) != -1) {
                    fos.write(b, 0, nRead);
                }
                fos.flush();
                fos.close();
                in.close();

            } catch (Exception e) {
                stateInt = 0;
                e.printStackTrace();
            } finally {
            }
        }
        return stateInt;
    }

    /**
     * 将二进制转换成图片保存
     * @param imgFile 二进制流转换的字符串
     * @param imgPath 图片的保存路径
     * @param imgName 图片的名称
     * @return
     *      1：保存正常
     *      0：保存失败
     */
    public static int saveToImgByBytes(File imgFile,String imgPath,String imgName){
        System.out.println("二进制文件转换为图片文件...");
        int stateInt = 1;
        if(imgFile.length() > 0){
            try {
                File file=new File(imgPath,imgName);//可以是任何图片格式.jpg,.png等
                FileOutputStream fos=new FileOutputStream(file);

                FileInputStream fis = new FileInputStream(imgFile);

                byte[] b = new byte[1024];
                int nRead = 0;
                while ((nRead = fis.read(b)) != -1) {
                    fos.write(b, 0, nRead);
                }
                fos.flush();
                fos.close();
                fis.close();

            } catch (Exception e) {
                stateInt = 0;
                e.printStackTrace();
            } finally {
            }
        }
        return stateInt;
    }

    /**
     * 二进制转字符串
     * @param b
     * @return
     */
    public static String byte2hex(byte[] b) {
        System.out.println("二进制开始转字符串...");
        StringBuffer sb = new StringBuffer();
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1) {
                sb.append("0" + stmp);
            } else {
                sb.append(stmp);
            }
        }
        return sb.toString();
    }

    /**
     * 字符串转二进制
     * @param str 要转换的字符串
     * @return  转换后的二进制数组
     */
    public static byte[] hex2byte(String str) {
        System.out.println("字符串开始转为二进制数组...");
        if (str == null)
            return null;
        str = str.trim();
        int len = str.length();
        if (len == 0 || len % 2 == 1)
            return null;
        byte[] b = new byte[len / 2];
        try {
            for (int i = 0; i < str.length(); i += 2) {
                b[i / 2] = (byte) Integer
                        .decode("0X" + str.substring(i, i + 2)).intValue();
            }
            return b;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 将图片转换为二进制流
     * @param imgPath
     */
    public byte[] imgToBinary(String imgPath) {
        File file = new File(imgPath);
        System.out.println("图片文件开始转换为二进制流文件...");
        FileInputStream fis;
        byte[] b = null;
        try
        {
            fis = new FileInputStream(file);
            b = new byte[fis.available()];
            fis.read(b);
            System.out.println("图片已经转化为二进制流...");
            // 把字节数组的图片写到另一个地方
            /*File apple = new File("F:\\松江网站文件\\images\\beiyong.jpg");

            if (apple.exists()) {
                apple.delete();
            }
            FileOutputStream fos = new FileOutputStream(apple);
            fos.write(b);
            fos.flush();
            fos.close();*/
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return b;
    }

    /**
     * 将字节流写入文件
     * @param filename
     * @param bytes
     */
    public void writeToFile(String filename, byte[] bytes) {
        FileOutputStream fos = null;
        try {
            File toFile = new File(filename);
            fos = new FileOutputStream(toFile);
            fos.write(bytes);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        ImgConvert file = new ImgConvert();
        byte[] bytes = file.imgToBinary("F:\\松江网站文件\\images\\beiyong.png");
        String binaryStr = byte2hex(bytes);
        file.writeToFile("C:\\Users\\YinYichang\\Desktop\\test\\file", bytes);
        file.saveToImgByStr(binaryStr,"C:\\Users\\YinYichang\\Desktop\\test", "newImg.bmp");
        //file.saveToImgByStr("", "", "");
    }
}
