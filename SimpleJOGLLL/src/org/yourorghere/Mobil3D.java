package org.yourorghere;

import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.geometry.GeometryInfo;
import com.sun.j3d.utils.geometry.NormalGenerator;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.universe.*;
import java.awt.*;
import javax.media.j3d.*;
import javax.swing.*;
import javax.vecmath.*;
public class Mobil3D extends JApplet{

    TransformGroup mobil, badan, tban1, tban2, roda1, roda2, roda3, roda4;
    TransformGroup rot;
    TransformGroup kaca;

    Transform3D trans = new Transform3D();
    Vector3f vector = new Vector3f();

    Box box;
    Cylinder silinder;
    
    public Mobil3D(){
        setLayout(new BorderLayout());
        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas = new Canvas3D(config);
        add("Center",canvas);

        BranchGroup scene = createSceneGraph();
        scene.compile();

        SimpleUniverse simU = new SimpleUniverse(canvas);
        simU.getViewingPlatform().setNominalViewingTransform();
        simU.addBranchGraph(scene);
    }

    Appearance apr(float r, float g, float b){
        Color3f red = new Color3f(r,g,b);
        Color3f black = new Color3f(0.0f,0.0f,0.0f);
        Color3f white = new Color3f(1.0f,1.0f,1.0f);
        //mix warna
        Material material = new Material(red, black, red, white, 100);
        Appearance appearance = new Appearance();
        appearance.setMaterial(material);
        return appearance;
    }

    Transform3D transform(float x, float y, float z) {
        vector.set(x, y, z);
        trans.set(vector);
        return trans;
    }

    TransformGroup putarz (double d1, double d2){
        Transform3D rotate = new Transform3D();
        Transform3D temprotate = new Transform3D();
        rotate.rotZ(Math.PI/d1);
        temprotate.rotX(Math.PI/d2);
        rotate.mul(temprotate);
        TransformGroup objRotate = new TransformGroup(rotate);
        return objRotate;
    }
    
    void mobil(){
        mobil = new TransformGroup();
        mobil.setTransform(transform(0.0f, 0.0f, 0.0f));

        badan = new TransformGroup();
        
        Point3f [] pointMobil = {
            new Point3f(-2.8f, -0.2f, 0.0f),//0
            new Point3f(-0.8f, -0.2f, 0.0f),//1
            new Point3f(-2.4f, 0.8f, 0.0f),//2
            new Point3f(-1.2f, 1.0f, 0.0f),//3
            new Point3f(-0.5f, 0.5f, 0.0f),//4
            new Point3f(-0.7f, 2.0f, 0.0f),//5
            new Point3f(1.0f, 2.0f, 0.0f),//6
            new Point3f(0.2f, 0.5f, 0.0f),//7
            new Point3f(0.5f, -0.2f, 0.0f),//8
            new Point3f(2.3f, -0.2f, 0.0f),//9
            new Point3f(2.6f, 0.5f, 0.0f),//10
            new Point3f(3.4f, 2.0f, 0.0f),//11
            new Point3f(3.2f, 0.5f, 0.0f),//12
            new Point3f(3.9f, 1.0f, 0.0f),//13
            new Point3f(3.9f, -0.2f, 0.0f),//14
            new Point3f(3.5f, -0.2f, 0.0f),//15

            new Point3f(-2.8f, -0.2f, -2.0f),//16
            new Point3f(-0.8f, -0.2f, -2.0f),//17
            new Point3f(-2.4f, 0.8f, -2.0f),//18
            new Point3f(-1.2f, 1.0f, -2.0f),//19
            new Point3f(-0.5f, 0.5f, -2.0f),//20
            new Point3f(-0.7f, 2.0f, -2.0f),//21
            new Point3f(1.0f, 2.0f, -2.0f),//22
            new Point3f(0.2f, 0.5f, -2.0f),//23
            new Point3f(0.5f, -0.2f, -2.0f),//24
            new Point3f(2.3f, -0.2f, -2.0f),//25
            new Point3f(2.6f, 0.5f, -2.0f),//26
            new Point3f(3.4f, 2.0f, -2.0f),//27
            new Point3f(3.2f, 0.5f, -2.0f),//28
            new Point3f(3.9f, 1.0f, -2.0f),//29
            new Point3f(3.9f, -0.2f, -2.0f),//30
            new Point3f(3.5f, -0.2f, -2.0f),//31

            new Point3f(-0.8f, -0.2f, -1.5f),//32
            new Point3f(-0.8f, -0.2f, -0.5f),//33
            new Point3f(0.5f, -0.2f, -0.5f),//34
            new Point3f(0.5f, -0.2f, -1.5f),//35

            new Point3f(2.3f, -0.2f, -1.5f),//36
            new Point3f(2.3f, -0.2f, -0.5f),//37
            new Point3f(3.5f, -0.2f, -0.5f),//38
            new Point3f(3.5f, -0.2f, -1.5f)//39
        };

        int coordinate[] = {
            1, 2, 0,
            3, 2, 1,
            4, 3, 1,
            5, 3, 4,
            6, 5, 4,
            7, 6, 4,
            8, 6, 7,
            9, 6, 8,
            10, 6, 9,
            11, 6, 10,
            12, 11, 10,
            13, 11, 12,
            14, 13, 12,
            15, 14, 12,
            16, 18, 17,
            17, 18, 19,
            17, 19, 20,
            20, 19, 21,
            20, 21, 22,
            20, 22, 23,
            23, 22, 24,
            24, 22, 25,
            25, 22, 26,
            26, 22, 27,
            26, 27, 28,
            28, 27, 29,
            28, 29, 30,
            28, 30, 31,
            //atas
            0, 2, 16,
            2, 18, 16,
            2, 3, 18,
            3, 19, 18,
            3, 5, 19,
            5, 21, 19,
            5, 6, 21,
            6, 22, 21,
            6, 11, 22,
            11, 27, 22,
            11, 13, 27,
            13, 29, 27,
            13, 14, 29,
            14, 30, 29,
            //bawah
            16, 1, 0,
            16, 17, 1,
            31, 14, 15,
            31, 30, 14,
            24, 9, 8,
            24, 25, 9,
            //roda
            34, 33, 35,
            33, 32, 35,
            38, 37, 39,
            37, 36, 39
        };

        GeometryInfo gi = new GeometryInfo(GeometryInfo.TRIANGLE_ARRAY);
        gi.setCoordinates(pointMobil);
        gi.setCoordinateIndices(coordinate);
        NormalGenerator ng = new NormalGenerator();
        ng.generateNormals(gi);
        GeometryArray te = gi.getGeometryArray();

        Shape3D car = new Shape3D(te, apr(1.0f, 0.0f, 0.0f));
        badan.addChild(car);
        mobil.addChild(badan);

        tban1 = new TransformGroup();
        tban1.setTransform(transform(-0.15f, 0.0f, -1.0f));
        silinder = new Cylinder(0.1f, 2.25f, apr(1.0f, 1.0f, 1.0f));
        rot = putarz(1.0f, 2.0f);
        rot.addChild(silinder);
        tban1.addChild(rot);
        mobil.addChild(tban1);

        tban2 = new TransformGroup();
        tban2.setTransform(transform(2.9f, 0.0f, -1.0f));
        silinder = new Cylinder(0.1f, 2.25f, apr(1.0f, 1.0f, 1.0f));
        rot = putarz(1.0f, 2.0f);
        rot.addChild(silinder);
        tban2.addChild(rot);
        mobil.addChild(tban2);

        roda1 = new TransformGroup();
        roda1.setTransform(transform(-0.15f, 0.0f, -0.1f));
        silinder = new Cylinder(0.5f, 0.5f, apr(1.0f, 1.0f, 1.0f));
        rot = putarz(1.0f, 2.0f);
        rot.addChild(silinder);
        roda1.addChild(rot);
        mobil.addChild(roda1);
        
        roda2 = new TransformGroup();
        roda2.setTransform(transform(2.9f, 0.0f, -0.1f));
        silinder = new Cylinder(0.5f, 0.5f, apr(1.0f, 1.0f, 1.0f));
        rot = putarz(1.0f, 2.0f);
        rot.addChild(silinder);
        roda2.addChild(rot);
        mobil.addChild(roda2);

        roda3 = new TransformGroup();
        roda3.setTransform(transform(2.9f, 0.0f, -1.9f));
        silinder = new Cylinder(0.5f, 0.5f, apr(1.0f, 1.0f, 1.0f));
        rot = putarz(1.0f, 2.0f);
        rot.addChild(silinder);
        roda3.addChild(rot);
        mobil.addChild(roda3);

        roda4 = new TransformGroup();
        roda4.setTransform(transform(-0.15f, 0.0f, -1.9f));
        silinder = new Cylinder(0.5f, 0.5f, apr(1.0f, 1.0f, 1.0f));
        rot = putarz(1.0f, 2.0f);
        rot.addChild(silinder);
        roda4.addChild(rot);
        mobil.addChild(roda4);

        //kaca
        kaca = new TransformGroup();
        kaca.setTransform(transform(0.0f, 0.0f, 0.0f));

        Point3f[]pointkaca = {
            new Point3f(-1.25f, 0.95f, -0.1f),//0
            new Point3f(-0.75f, 1.9f, -0.1f),//1
            new Point3f(-0.75f, 1.9f, -1.9f),//2
            new Point3f(-1.25f, 0.95f, -1.9f),//3

            new Point3f(-1.15f, 0.95f, 0.05f),//4
            new Point3f(-0.7f, 1.85f, 0.05f),//5
            new Point3f(-0.7f, 0.95f, 0.05f),//6

            new Point3f(-1.15f, 0.95f, -2.05f),//7
            new Point3f(-0.7f, 1.85f, -2.05f),//8
            new Point3f(-0.7f, 0.95f, -2.05f),//9

            new Point3f(-0.5f, 0.95f, 0.05f),//10
            new Point3f(1.3f, 0.95f, 0.05f),//11
            new Point3f(1.3f, 1.85f, 0.05f),//12
            new Point3f(-0.5f, 1.85f, 0.05f),//13

            new Point3f(1.5f, 0.95f, 0.05f),//14
            new Point3f(3.3f, 0.95f, 0.05f),//15
            new Point3f(3.3f, 1.85f, 0.05f),//16
            new Point3f(1.5f, 1.85f, 0.05f),//17

            new Point3f(-0.5f, 0.95f, -2.05f),//18
            new Point3f(1.3f, 0.95f, -2.05f),//19
            new Point3f(1.3f, 1.85f, -2.05f),//20
            new Point3f(-0.5f, 1.85f, -2.05f),//21

            new Point3f(1.5f, 0.95f, -2.05f),//22
            new Point3f(3.3f, 0.95f, -2.05f),//23
            new Point3f(3.3f, 1.85f, -2.05f),//24
            new Point3f(1.5f, 1.85f, -2.05f),//25

            new Point3f(3.95f, 0.95f, -0.1f),//26
            new Point3f(3.45f, 1.9f, -0.1f),//27
            new Point3f(3.45f, 1.9f, -1.9f),//28
            new Point3f(3.95f, 0.95f, -1.9f),//29
        };

        int coor [] = {
            1, 2, 0,
            2, 3, 0,
            6, 5, 4,
            7, 8, 9,

            11, 12, 10,
            12, 13, 10,

            15, 16, 14,
            16, 17, 14,

            18, 20, 19,
            18, 21, 20,

            22, 24, 23,
            22, 25, 24,

            26, 28, 27,
            26, 29, 28
        };
        
        GeometryInfo gi2 = new GeometryInfo(GeometryInfo.TRIANGLE_ARRAY);
        gi2.setCoordinates(pointkaca);
        gi2.setCoordinateIndices(coor);
        NormalGenerator ng2 = new NormalGenerator();
        ng.generateNormals(gi2);
        GeometryArray te2 = gi2.getGeometryArray();

        Shape3D mirror = new Shape3D(te2, apr(0.0f, 1.0f, 1.0f));
        kaca.addChild(mirror);
        mobil.addChild(kaca);

        Transform3D mobilFlightAxis = new Transform3D();
        mobilFlightAxis.rotX(Math.PI/1);

        Alpha mobilAlpha = new Alpha(10,Alpha.INCREASING_ENABLE+Alpha.DECREASING_ENABLE,
                                      0,0,3000,30,
                                      0,3000,30,0);

        //The movement for the flight.
        PositionInterpolator posIPmobil = new PositionInterpolator(mobilAlpha,
                                                   mobil,mobilFlightAxis,
                                                   5.0f,0.0f);
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0),Double.MAX_VALUE);
        posIPmobil.setSchedulingBounds(bounds);

        mobil.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        mobil.addChild(posIPmobil);
    
    }
    public BranchGroup createSceneGraph() {
        BranchGroup root = new BranchGroup();
        TransformGroup objScale = new TransformGroup();
        //membuat transformasi
        Transform3D scaleTrans = new Transform3D();
        scaleTrans.set(1/6.0f);
        objScale.setTransform(scaleTrans);
        root.addChild(objScale);

        //objek transformasi
        TransformGroup objTrans = new TransformGroup();
        objTrans.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        objTrans.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        objScale.addChild(objTrans);
        mobil();

        objTrans.addChild(mobil);

        BoundingSphere bounds = new BoundingSphere(new Point3d(), 100);
        Background bg = new Background(new Color3f(1.0f, 1.0f, 1.0f));
        bg.setApplicationBounds(bounds);
        objTrans.addChild(bg);

        //mengatur mouse
        MouseRotate mr = new MouseRotate();
        mr.setTransformGroup(objTrans);
        mr.setSchedulingBounds(bounds);
        mr.setFactor(0.007);
        objTrans.addChild(mr);

        //mengatur terang
        Color3f ambientColor = new Color3f(0.1f, 0.1f, 0.1f);
        //penyebaran
        AmbientLight ambientLightNode = new AmbientLight(ambientColor);
        ambientLightNode.setInfluencingBounds(bounds);
        root.addChild(ambientLightNode);
        Color3f light1Color = new Color3f(1.0f, 1.0f, 1.0f);
        Vector3f light1Direction = new Vector3f(0.0f, -12.0f, -12.0f);
//        Vector3f light1Direction = new Vector3f(-0.2f, 0.0f, -0.8f);
        DirectionalLight light1 = new DirectionalLight(light1Color, light1Direction);
        light1.setInfluencingBounds(bounds);
        root.addChild(light1);

        return root;
    }
    public static void main(String[] args) {
        Frame frame = new MainFrame(new Mobil3D(), 500,400);
        frame.setTitle("Mobil 3D");
        frame.setLocationRelativeTo(null);
    }
}