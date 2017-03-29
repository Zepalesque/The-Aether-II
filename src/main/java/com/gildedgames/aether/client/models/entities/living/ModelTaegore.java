package com.gildedgames.aether.client.models.entities.living;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelTaegore extends ModelBase
{
	public ModelRenderer Tail;

	public ModelRenderer HeadMain;

	public ModelRenderer HeadThroat;

	public ModelRenderer HeadSnoutRight;

	public ModelRenderer HeadSnoutLeft;

	public ModelRenderer HeadSnout;

	public ModelRenderer HeadJawBack;

	public ModelRenderer HeadSnoutRidge;

	public ModelRenderer HeadBrowLeft;

	public ModelRenderer HeadBrowRight;

	public ModelRenderer HeadEyeLeft;

	public ModelRenderer HeadEyeRight;

	public ModelRenderer HeadCrestMiddle;

	public ModelRenderer HeadCrestLeft;

	public ModelRenderer HeadCrestRight;

	public ModelRenderer HeadCrestBase;

	public ModelRenderer HeadTuskLeft;

	public ModelRenderer HeadTuskRight;

	public ModelRenderer HeadBeardMiddle;

	public ModelRenderer HeadBeardRight;

	public ModelRenderer HeadBeardLeft;

	public ModelRenderer HeadEarLeft;

	public ModelRenderer HeadEarRight;

	public ModelRenderer HeadRuffTop;

	public ModelRenderer HeadRuffLeft;

	public ModelRenderer HeadRuffRight;

	public ModelRenderer HeadJawFront;

	public ModelRenderer TorsoNeck;

	public ModelRenderer TorsoBack;

	public ModelRenderer TorsoSpine;

	public ModelRenderer TorsoBelly;

	public ModelRenderer TorsoFront;

	public ModelRenderer TorsoShoulderPlateLeft1;

	public ModelRenderer TorsoShoulderPlateRight1;

	public ModelRenderer TorsoShoulderPlateLeft2;

	public ModelRenderer TorsoShoulderPlateRight2;

	public ModelRenderer TorsoBackPlateRight;

	public ModelRenderer TorsoBackPlateLeft;

	public ModelRenderer FrontLegLeftUpper;

	public ModelRenderer FrontLegLeftLower;

	public ModelRenderer FrontLegLeftToeMiddle;

	public ModelRenderer FrontLegLeftToeOut;

	public ModelRenderer FrontLegLeftToeIn;

	public ModelRenderer FrontLegRightUpper;

	public ModelRenderer FrontLegRightLower;

	public ModelRenderer FrontLegRightToeMiddle;

	public ModelRenderer FrontLegRightToeOut;

	public ModelRenderer FrontLegRightToeIn;

	public ModelRenderer HindLegLeftCalf;

	public ModelRenderer HindLegLeftKnee;

	public ModelRenderer HindLegLeftShin;

	public ModelRenderer HindLegLeftToeMiddle;

	public ModelRenderer HindLegLeftToeOut;

	public ModelRenderer HindLegLeftToeIn;

	public ModelRenderer HindLegRightCalf;

	public ModelRenderer HindLegRightKnee;

	public ModelRenderer HindLegRightShin;

	public ModelRenderer HindLegRightToeMiddle;

	public ModelRenderer HindLegRightToeOut;

	public ModelRenderer HindLegRightToeIn;

	public ModelTaegore()
	{
		this.textureWidth = 128;
		this.textureHeight = 256;
		this.HeadJawFront = new ModelRenderer(this, 61, 70);
		this.HeadJawFront.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HeadJawFront.addBox(-1.5F, 8.0F, -17.0F, 3, 3, 4, 0.0F);
		this.HeadSnoutRight = new ModelRenderer(this, 28, 42);
		this.HeadSnoutRight.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HeadSnoutRight.addBox(-8.0F, 0.5F, -14.0F, 3, 6, 10, 0.0F);
		this.setRotateAngle(HeadSnoutRight, 0.29792770331543206F, -0.39112828537192923F, -0.09442231253289324F);
		this.HeadBeardLeft = new ModelRenderer(this, 71, 69);
		this.HeadBeardLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HeadBeardLeft.addBox(1.5F, 11.0F, -17.0F, 0, 3, 8, 0.0F);
		this.HeadCrestBase = new ModelRenderer(this, 52, 15);
		this.HeadCrestBase.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HeadCrestBase.addBox(-1.0F, -7.0F, -7.0F, 8, 3, 8, 0.0F);
		this.setRotateAngle(HeadCrestBase, 0.5026548245743669F, 0.7272786993060372F, 0.35377823937925057F);
		this.FrontLegLeftToeOut = new ModelRenderer(this, 83, 235);
		this.FrontLegLeftToeOut.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.FrontLegLeftToeOut.addBox(1.6F, 17.0F, -2.3F, 1, 2, 1, 0.0F);
		this.setRotateAngle(FrontLegLeftToeOut, 0.0F, -0.4363323129985824F, 0.0F);
		this.HeadCrestLeft = new ModelRenderer(this, 76, 8);
		this.HeadCrestLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HeadCrestLeft.addBox(2.0F, -9.0F, -7.0F, 2, 3, 4, 0.0F);
		this.setRotateAngle(HeadCrestLeft, 0.2617993877991494F, -0.0F, 0.17453292519943295F);
		this.HeadRuffRight = new ModelRenderer(this, 40, 22);
		this.HeadRuffRight.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HeadRuffRight.addBox(-6.5F, -4.0F, -0.5F, 0, 10, 5, 0.0F);
		this.setRotateAngle(HeadRuffRight, 0.0F, -0.4363323129985824F, 0.0F);
		this.HindLegLeftShin = new ModelRenderer(this, 97, 236);
		this.HindLegLeftShin.setRotationPoint(7.0F, 6.0F, 14.0F);
		this.HindLegLeftShin.addBox(-1.0F, 10.0F, -2.0F, 3, 8, 5, 0.0F);
		this.TorsoShoulderPlateLeft1 = new ModelRenderer(this, 82, 105);
		this.TorsoShoulderPlateLeft1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.TorsoShoulderPlateLeft1.addBox(5.0F, -1.0F, -8.5F, 4, 15, 7, 0.0F);
		this.setRotateAngle(TorsoShoulderPlateLeft1, 0.0F, -0.0F, -0.34906584024429316F);
		this.FrontLegRightToeOut = new ModelRenderer(this, 49, 235);
		this.FrontLegRightToeOut.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.FrontLegRightToeOut.addBox(-2.6F, 17.0F, -2.3F, 1, 2, 1, 0.0F);
		this.setRotateAngle(FrontLegRightToeOut, 0.0F, 0.4363323129985824F, 0.0F);
		this.FrontLegLeftToeMiddle = new ModelRenderer(this, 77, 235);
		this.FrontLegLeftToeMiddle.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.FrontLegLeftToeMiddle.addBox(0.0F, 17.0F, -1.5F, 2, 2, 1, 0.0F);
		this.HeadJawBack = new ModelRenderer(this, 57, 80);
		this.HeadJawBack.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HeadJawBack.addBox(-2.0F, 8.5F, -12.0F, 4, 4, 7, 0.0F);
		this.setRotateAngle(HeadJawBack, -0.12932889757277982F, -0.0F, 0.0F);
		this.HindLegRightKnee = new ModelRenderer(this, 17, 222);
		this.HindLegRightKnee.setRotationPoint(-7.0F, 6.0F, 14.0F);
		this.HindLegRightKnee.addBox(-2.5F, 9.0F, -5.0F, 4, 4, 10, 0.0F);
		this.setRotateAngle(HindLegRightKnee, -0.17453292012214658F, -0.0F, 0.0F);
		this.HeadBrowLeft = new ModelRenderer(this, 68, 58);
		this.HeadBrowLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HeadBrowLeft.addBox(-4.8F, -2.0F, -9.0F, 5, 2, 2, 0.0F);
		this.setRotateAngle(HeadBrowLeft, 0.0F, -0.6981317007977318F, 0.0F);
		this.HeadEarLeft = new ModelRenderer(this, 86, 37);
		this.HeadEarLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HeadEarLeft.addBox(4.0F, 1.0F, -6.0F, 4, 4, 1, 0.0F);
		this.setRotateAngle(HeadEarLeft, 0.2617993877991494F, -0.0F, -1.0471975511965976F);
		this.TorsoBack = new ModelRenderer(this, 31, 124);
		this.TorsoBack.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.TorsoBack.addBox(-6.0F, -2.0F, -9.0F, 12, 15, 25, 0.0F);
		this.setRotateAngle(TorsoBack, -0.2617993950843811F, -0.0F, 0.0F);
		this.TorsoShoulderPlateRight2 = new ModelRenderer(this, 12, 109);
		this.TorsoShoulderPlateRight2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.TorsoShoulderPlateRight2.addBox(-8.0F, -1.0F, -4.0F, 3, 11, 7, 0.0F);
		this.setRotateAngle(TorsoShoulderPlateRight2, 0.06923949821968768F, 0.25268026165818797F, 0.27059742313116786F);
		this.HeadRuffLeft = new ModelRenderer(this, 86, 22);
		this.HeadRuffLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HeadRuffLeft.addBox(6.5F, -4.0F, -0.5F, 0, 10, 5, 0.0F);
		this.setRotateAngle(HeadRuffLeft, 0.0F, 0.4363323129985824F, 0.0F);
		this.HeadBrowRight = new ModelRenderer(this, 54, 58);
		this.HeadBrowRight.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HeadBrowRight.addBox(-0.2F, -2.0F, -9.0F, 5, 2, 2, 0.0F);
		this.setRotateAngle(HeadBrowRight, 0.0F, 0.6981317007977318F, 0.0F);
		this.HindLegLeftToeIn = new ModelRenderer(this, 99, 249);
		this.HindLegLeftToeIn.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HindLegLeftToeIn.addBox(-0.3F, 16.0F, -2.4F, 1, 2, 1, 0.0F);
		this.setRotateAngle(HindLegLeftToeIn, 0.0F, 0.4363323129985824F, 0.0F);
		this.TorsoFront = new ModelRenderer(this, 56, 98);
		this.TorsoFront.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.TorsoFront.addBox(-4.0F, 7.0F, -14.0F, 8, 6, 4, 0.0F);
		this.setRotateAngle(TorsoFront, 0.2617993950843811F, -0.0F, 0.0F);
		this.FrontLegLeftToeIn = new ModelRenderer(this, 73, 235);
		this.FrontLegLeftToeIn.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.FrontLegLeftToeIn.addBox(-0.8F, 17.0F, -1.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(FrontLegLeftToeIn, 0.0F, 0.4363323129985824F, 0.0F);
		this.HeadBeardRight = new ModelRenderer(this, 49, 69);
		this.HeadBeardRight.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HeadBeardRight.addBox(-1.5F, 11.0F, -17.0F, 0, 3, 8, 0.0F);
		this.HindLegRightToeIn = new ModelRenderer(this, 33, 249);
		this.HindLegRightToeIn.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HindLegRightToeIn.addBox(-0.7F, 16.0F, -2.4F, 1, 2, 1, 0.0F);
		this.setRotateAngle(HindLegRightToeIn, 0.0F, -0.4363323129985824F, 0.0F);
		this.HeadRuffTop = new ModelRenderer(this, 51, 0);
		this.HeadRuffTop.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HeadRuffTop.addBox(-5.5F, -5.0F, 0.5F, 11, 0, 6, 0.0F);
		this.setRotateAngle(HeadRuffTop, 0.6108652381980153F, -0.0F, 0.0F);
		this.HindLegLeftKnee = new ModelRenderer(this, 91, 222);
		this.HindLegLeftKnee.setRotationPoint(7.0F, 6.0F, 14.0F);
		this.HindLegLeftKnee.addBox(-1.5F, 9.0F, -5.0F, 4, 4, 10, 0.0F);
		this.setRotateAngle(HindLegLeftKnee, -0.17453292012214658F, -0.0F, 0.0F);
		this.HeadSnoutRidge = new ModelRenderer(this, 54, 44);
		this.HeadSnoutRidge.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HeadSnoutRidge.addBox(-2.0F, -8.5F, -13.0F, 4, 4, 10, 0.0F);
		this.setRotateAngle(HeadSnoutRidge, 0.8726646259971648F, -0.0F, 0.0F);
		this.HindLegRightCalf = new ModelRenderer(this, 18, 202);
		this.HindLegRightCalf.setRotationPoint(-7.0F, 6.0F, 14.0F);
		this.HindLegRightCalf.addBox(-3.0F, 0.0F, -4.0F, 5, 12, 8, 0.0F);
		this.setRotateAngle(HindLegRightCalf, -0.34906584024429316F, -0.0F, 0.0F);
		this.HeadEyeLeft = new ModelRenderer(this, 82, 58);
		this.HeadEyeLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HeadEyeLeft.addBox(-5.5F, -1.0F, -8.5F, 4, 5, 2, 0.0F);
		this.setRotateAngle(HeadEyeLeft, 0.0F, -0.7853981633974483F, 0.0F);
		this.FrontLegLeftUpper = new ModelRenderer(this, 68, 202);
		this.FrontLegLeftUpper.setRotationPoint(7.0F, 5.0F, -5.0F);
		this.FrontLegLeftUpper.addBox(-2.0F, 0.0F, -3.0F, 6, 11, 6, 0.0F);
		this.setRotateAngle(FrontLegLeftUpper, 0.17453292012214658F, -0.0F, 0.0F);
		this.FrontLegLeftLower = new ModelRenderer(this, 70, 219);
		this.FrontLegLeftLower.setRotationPoint(7.0F, 5.0F, -5.0F);
		this.FrontLegLeftLower.addBox(-1.5F, 8.0F, -0.6000000238418579F, 5, 11, 5, 0.0F);
		this.FrontLegRightLower = new ModelRenderer(this, 46, 219);
		this.FrontLegRightLower.setRotationPoint(-7.0F, 5.0F, -5.0F);
		this.FrontLegRightLower.addBox(-3.5F, 8.0F, -0.6F, 5, 11, 5, 0.0F);
		this.FrontLegRightUpper = new ModelRenderer(this, 44, 202);
		this.FrontLegRightUpper.setRotationPoint(-7.0F, 5.0F, -5.0F);
		this.FrontLegRightUpper.addBox(-4.0F, 0.0F, -3.0F, 6, 11, 6, 0.0F);
		this.setRotateAngle(FrontLegRightUpper, 0.17453292012214658F, -0.0F, 0.0F);
		this.HindLegRightToeMiddle = new ModelRenderer(this, 29, 249);
		this.HindLegRightToeMiddle.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HindLegRightToeMiddle.addBox(-1.0F, 16.0F, -2.5F, 1, 2, 1, 0.0F);
		this.HeadSnoutLeft = new ModelRenderer(this, 82, 42);
		this.HeadSnoutLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HeadSnoutLeft.addBox(5.0F, 0.5F, -14.0F, 3, 6, 10, 0.0F);
		this.setRotateAngle(HeadSnoutLeft, 0.29792770331543206F, 0.39112828537192923F, 0.09442231253289324F);
		this.HeadCrestRight = new ModelRenderer(this, 48, 8);
		this.HeadCrestRight.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HeadCrestRight.addBox(-4.0F, -9.0F, -7.0F, 2, 3, 4, 0.0F);
		this.setRotateAngle(HeadCrestRight, 0.2617993877991494F, -0.0F, -0.17453292519943295F);
		this.HindLegLeftToeOut = new ModelRenderer(this, 107, 249);
		this.HindLegLeftToeOut.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HindLegLeftToeOut.addBox(0.2F, 16.0F, -2.8F, 1, 2, 1, 0.0F);
		this.setRotateAngle(HindLegLeftToeOut, 0.0F, -0.4363323129985824F, 0.0F);
		this.FrontLegRightToeMiddle = new ModelRenderer(this, 53, 235);
		this.FrontLegRightToeMiddle.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.FrontLegRightToeMiddle.addBox(-2.0F, 17.0F, -1.5F, 2, 2, 1, 0.0F);
		this.HeadBeardMiddle = new ModelRenderer(this, 65, 77);
		this.HeadBeardMiddle.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HeadBeardMiddle.addBox(-1.5F, 11.0F, -17.0F, 3, 3, 0, 0.0F);
		this.HindLegRightToeOut = new ModelRenderer(this, 25, 249);
		this.HindLegRightToeOut.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HindLegRightToeOut.addBox(-1.2F, 16.0F, -2.8F, 1, 2, 1, 0.0F);
		this.setRotateAngle(HindLegRightToeOut, 0.0F, 0.4363323129985824F, 0.0F);
		this.HeadCrestMiddle = new ModelRenderer(this, 60, 6);
		this.HeadCrestMiddle.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HeadCrestMiddle.addBox(-1.5F, -9.0F, -8.0F, 3, 4, 5, 0.0F);
		this.setRotateAngle(HeadCrestMiddle, 0.2617993877991494F, -0.0F, 0.0F);
		this.HeadTuskRight = new ModelRenderer(this, 56, 62);
		this.HeadTuskRight.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HeadTuskRight.addBox(-4.0F, 4.0F, -15.0F, 1, 5, 1, 0.0F);
		this.setRotateAngle(HeadTuskRight, 0.0F, -0.0F, -0.17453292519943295F);
		this.HeadEarRight = new ModelRenderer(this, 40, 37);
		this.HeadEarRight.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HeadEarRight.addBox(-8.0F, 1.0F, -6.0F, 4, 4, 1, 0.0F);
		this.setRotateAngle(HeadEarRight, 0.2617993877991494F, -0.0F, 1.0471975511965976F);
		this.TorsoSpine = new ModelRenderer(this, 43, 139);
		this.TorsoSpine.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.TorsoSpine.addBox(0.0F, -4.0F, -9.0F, 0, 2, 25, 0.0F);
		this.setRotateAngle(TorsoSpine, -0.2617993950843811F, -0.0F, 0.0F);
		this.TorsoNeck = new ModelRenderer(this, 54, 108);
		this.TorsoNeck.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.TorsoNeck.addBox(-5.0F, -3.0F, -12.0F, 10, 12, 4, 0.0F);
		this.HeadEyeRight = new ModelRenderer(this, 42, 58);
		this.HeadEyeRight.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HeadEyeRight.addBox(1.5F, -1.0F, -8.5F, 4, 5, 2, 0.0F);
		this.setRotateAngle(HeadEyeRight, 0.0F, 0.7853981633974483F, 0.0F);
		this.Tail = new ModelRenderer(this, 0, 61);
		this.Tail.setRotationPoint(0.0F, 2.0F, 16.0F);
		this.Tail.addBox(-7.0F, 0.0F, -7.0F, 8, 16, 8, 0.0F);
		this.setRotateAngle(Tail, 0.7621319882394909F, -0.6491209619999105F, -0.5096392150483358F);
		this.HeadMain = new ModelRenderer(this, 50, 26);
		this.HeadMain.setRotationPoint(0.0F, 2.0F, -11.0F);
		this.HeadMain.addBox(-6.0F, -4.5F, -7.0F, 12, 12, 6, 0.0F);
		this.HindLegLeftCalf = new ModelRenderer(this, 92, 202);
		this.HindLegLeftCalf.setRotationPoint(7.0F, 6.0F, 14.0F);
		this.HindLegLeftCalf.addBox(-2.0F, 0.0F, -4.0F, 5, 12, 8, 0.0F);
		this.setRotateAngle(HindLegLeftCalf, -0.34906584024429316F, -0.0F, 0.0F);
		this.TorsoBelly = new ModelRenderer(this, 30, 166);
		this.TorsoBelly.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.TorsoBelly.addBox(-7.0F, 3.0F, -8.0F, 14, 12, 24, 0.0F);
		this.TorsoShoulderPlateLeft2 = new ModelRenderer(this, 104, 109);
		this.TorsoShoulderPlateLeft2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.TorsoShoulderPlateLeft2.addBox(5.0F, -1.0F, -4.0F, 3, 11, 7, 0.0F);
		this.setRotateAngle(TorsoShoulderPlateLeft2, 0.06923949821968768F, -0.25268026165818797F, -0.27059742313116786F);
		this.HeadThroat = new ModelRenderer(this, 79, 80);
		this.HeadThroat.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HeadThroat.addBox(-4.0F, 7.0F, -6.0F, 8, 6, 8, 0.0F);
		this.setRotateAngle(HeadThroat, -0.11152653920243764F, -0.0F, 0.0F);
		this.HindLegLeftToeMiddle = new ModelRenderer(this, 103, 249);
		this.HindLegLeftToeMiddle.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HindLegLeftToeMiddle.addBox(0.0F, 16.0F, -2.5F, 1, 2, 1, 0.0F);
		this.HeadTuskLeft = new ModelRenderer(this, 76, 62);
		this.HeadTuskLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HeadTuskLeft.addBox(3.0F, 4.0F, -15.0F, 1, 5, 1, 0.0F);
		this.setRotateAngle(HeadTuskLeft, 0.0F, -0.0F, 0.17453292519943295F);
		this.TorsoShoulderPlateRight1 = new ModelRenderer(this, 32, 105);
		this.TorsoShoulderPlateRight1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.TorsoShoulderPlateRight1.addBox(-9.0F, -1.0F, -8.5F, 4, 15, 7, 0.0F);
		this.setRotateAngle(TorsoShoulderPlateRight1, 0.0F, -0.0F, 0.34906584024429316F);
		this.FrontLegRightToeIn = new ModelRenderer(this, 59, 235);
		this.FrontLegRightToeIn.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.FrontLegRightToeIn.addBox(-0.2F, 17.0F, -1.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(FrontLegRightToeIn, 0.0F, -0.4363323129985824F, 0.0F);
		this.TorsoBackPlateLeft = new ModelRenderer(this, 82, 127);
		this.TorsoBackPlateLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.TorsoBackPlateLeft.addBox(5.5F, 3.0F, 9.0F, 4, 14, 8, 0.0F);
		this.setRotateAngle(TorsoBackPlateLeft, 0.07438152130324906F, -0.15803570099691838F, -0.4422247463038985F);
		this.HindLegRightShin = new ModelRenderer(this, 23, 236);
		this.HindLegRightShin.setRotationPoint(-7.0F, 6.0F, 14.0F);
		this.HindLegRightShin.addBox(-2.0F, 10.0F, -2.0F, 3, 8, 5, 0.0F);
		this.HeadSnout = new ModelRenderer(this, 60, 62);
		this.HeadSnout.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HeadSnout.addBox(-2.0F, 0.3F, -19.0F, 4, 4, 4, 0.0F);
		this.setRotateAngle(HeadSnout, 0.2617993877991494F, -0.0F, 0.0F);
		this.TorsoBackPlateRight = new ModelRenderer(this, 30, 127);
		this.TorsoBackPlateRight.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.TorsoBackPlateRight.addBox(-9.5F, 3.0F, 9.0F, 4, 14, 8, 0.0F);
		this.setRotateAngle(TorsoBackPlateRight, 0.07438152130324906F, 0.15803570099691838F, 0.4422247463038985F);
		this.HeadMain.addChild(this.HeadJawFront);
		this.HeadMain.addChild(this.HeadSnoutRight);
		this.HeadMain.addChild(this.HeadBeardLeft);
		this.HeadMain.addChild(this.HeadCrestBase);
		this.FrontLegLeftLower.addChild(this.FrontLegLeftToeOut);
		this.HeadMain.addChild(this.HeadCrestLeft);
		this.HeadMain.addChild(this.HeadRuffRight);
		this.FrontLegRightLower.addChild(this.FrontLegRightToeOut);
		this.FrontLegLeftLower.addChild(this.FrontLegLeftToeMiddle);
		this.HeadMain.addChild(this.HeadJawBack);
		this.HeadMain.addChild(this.HeadBrowLeft);
		this.HeadMain.addChild(this.HeadEarLeft);
		this.HeadMain.addChild(this.HeadRuffLeft);
		this.HeadMain.addChild(this.HeadBrowRight);
		this.HindLegLeftShin.addChild(this.HindLegLeftToeIn);
		this.FrontLegLeftLower.addChild(this.FrontLegLeftToeIn);
		this.HeadMain.addChild(this.HeadBeardRight);
		this.HindLegRightShin.addChild(this.HindLegRightToeIn);
		this.HeadMain.addChild(this.HeadRuffTop);
		this.HeadMain.addChild(this.HeadSnoutRidge);
		this.HeadMain.addChild(this.HeadEyeLeft);
		this.HindLegRightShin.addChild(this.HindLegRightToeMiddle);
		this.HeadMain.addChild(this.HeadSnoutLeft);
		this.HeadMain.addChild(this.HeadCrestRight);
		this.HindLegLeftShin.addChild(this.HindLegLeftToeOut);
		this.FrontLegRightLower.addChild(this.FrontLegRightToeMiddle);
		this.HeadMain.addChild(this.HeadBeardMiddle);
		this.HindLegRightShin.addChild(this.HindLegRightToeOut);
		this.HeadMain.addChild(this.HeadCrestMiddle);
		this.HeadMain.addChild(this.HeadTuskRight);
		this.HeadMain.addChild(this.HeadEarRight);
		this.HeadMain.addChild(this.HeadEyeRight);
		this.HeadMain.addChild(this.HeadThroat);
		this.HindLegLeftShin.addChild(this.HindLegLeftToeMiddle);
		this.HeadMain.addChild(this.HeadTuskLeft);
		this.FrontLegRightLower.addChild(this.FrontLegRightToeIn);
		this.HeadMain.addChild(this.HeadSnout);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		this.HindLegLeftShin.render(f5);
		this.TorsoShoulderPlateLeft1.render(f5);
		this.HindLegRightKnee.render(f5);
		this.TorsoBack.render(f5);
		this.TorsoShoulderPlateRight2.render(f5);
		this.TorsoFront.render(f5);
		this.HindLegLeftKnee.render(f5);
		this.HindLegRightCalf.render(f5);
		this.FrontLegLeftUpper.render(f5);
		this.FrontLegLeftLower.render(f5);
		this.FrontLegRightLower.render(f5);
		this.FrontLegRightUpper.render(f5);
		this.TorsoSpine.render(f5);
		this.TorsoNeck.render(f5);
		this.Tail.render(f5);
		this.HeadMain.render(f5);
		this.HindLegLeftCalf.render(f5);
		this.TorsoBelly.render(f5);
		this.TorsoShoulderPlateLeft2.render(f5);
		this.TorsoShoulderPlateRight1.render(f5);
		this.TorsoBackPlateLeft.render(f5);
		this.HindLegRightShin.render(f5);
		this.TorsoBackPlateRight.render(f5);
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch,
			float scaleFactor, Entity entity)
	{
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);

		this.Tail.rotateAngleZ = -0.5096392150483358F + (MathHelper.cos(ageInTicks * 0.1662F) * 0.2F);

		float pitch = headPitch * 0.017453292F;
		float yaw = netHeadYaw * 0.017453292F;

		this.HeadMain.rotateAngleX = pitch;
		this.HeadMain.rotateAngleY = yaw;

		float leftSwingX = (MathHelper.cos(limbSwing * 0.6662F) * 0.75F * limbSwingAmount);
		float rightSwingX = (MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.75F * limbSwingAmount);

		this.FrontLegLeftUpper.rotateAngleX = 0.17453292012214658F + leftSwingX;
		this.FrontLegLeftLower.rotateAngleX = leftSwingX;

		this.FrontLegRightUpper.rotateAngleX = 0.17453292012214658F + rightSwingX;
		this.FrontLegRightLower.rotateAngleX = rightSwingX;

		this.HindLegRightShin.rotateAngleX = leftSwingX;
		this.HindLegRightKnee.rotateAngleX = -0.17453292012214658F + leftSwingX;
		this.HindLegRightCalf.rotateAngleX = -0.34906584024429316F + leftSwingX;

		this.HindLegLeftShin.rotateAngleX = rightSwingX;
		this.HindLegLeftKnee.rotateAngleX = -0.17453292012214658F + rightSwingX;
		this.HindLegLeftCalf.rotateAngleX = -0.34906584024429316F + rightSwingX;
	}
}