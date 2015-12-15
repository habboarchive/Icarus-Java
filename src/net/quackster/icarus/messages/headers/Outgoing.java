package net.quackster.icarus.messages.headers;

public class Outgoing {

	public static final short InitCryptoMessageComposer = 2172;
	public static final short SecretKeyMessageComposer = 690;
	public static final short AuthenticationOKMessageComposer = 1552;//3151;
    public static final short UniqueMachineIDMessageComposer = 3683;//3540;
    public static final short DisconnectReasonMessageComposer = 4000;
    public static final short LandingWidgetMessageComposer = 1351;//986;
    public static final short LandingCommunityChallengeMessageComposer = 739;
    public static final short LandingPromosMessageComposer = 2682;
    public static final short LandingRewardMessageComposer = 2812;
    public static final short SendCampaignBadgeMessageComposer = 1811;
    public static final short HotelViewCountdownMessageComposer = 2315;
    public static final short HotelViewDailyquestMessageComposer = 1678;
    public static final short HotelViewHallOfFameMessageComposer = 3483;
    public static final short CompetitionEntrySubmitResultMessageComposer = 1998;
    public static final short CompetitionVotingInfoMessageComposer = 1181;
    public static final short UserObjectMessageComposer = 3762;//1096;
    public static final short SendPerkAllowancesMessageComposer = 2028;//1553;
    public static final short CreditsBalanceMessageComposer = 2588;//713;
    public static final short ActivityPointsMessageComposer = 1369;//74;
    public static final short AchievementPointsMessageComposer = 1560;
    public static final short SubscriptionStatusMessageComposer = 2645;
    public static final short UserClubRightsMessageComposer = 925;
    public static final short HomeRoomMessageComposer = 704;//2159;
    public static final short EnableTradingMessageComposer = 1711;
    public static final short MinimailCountMessageComposer = 2895;
    public static final short UserProfileMessageComposer = 2270;
    public static final short LoadVolumeMessageComposer = 426;
    public static final short LoadWardrobeMessageComposer = 2444;
    public static final short ReceiveBadgeMessageComposer = 3445;
    public static final short FigureSetIdsMessageComposer = 3281;
    public static final short LoveLockDialogueMessageComposer = 2413;
    public static final short LoveLockDialogueSetLockedMessageComposer = 3297;
    public static final short LoveLockDialogueCloseMessageComposer = 3016;
    public static final short NewbieStatusMessageComposer = 3978;
    public static final short IdentityAccountsMessageComposer = 1406;
    public static final short FlatCategoriesMessageComposer = 1625;//2217;
    public static final short OfficialRoomsMessageComposer = 972;
    public static final short NavigatorListingsMessageComposer = 135;
    public static final short FavouriteRoomsUpdateMessageComposer = 183;
    public static final short CanCreateRoomMessageComposer = 1913;
    public static final short PopularRoomTagsMessageComposer = 2914;
    public static final short FavouriteRoomsMessageComposer = 3455;
    public static final short NavigatorLiftedRoomsComposer = 2631;//1258;
    public static final short NavigatorMetaDataComposer = 3732;
    public static final short NavigatorSavedSearchesComposer = 591;//396;
    public static final short SearchResultSetComposer = 2247;//1071;
    public static final short NavigatorCategories = 162;//1836;
    public static final short NewNavigatorSizeMessageComposer = 2726;//329;
    public static final short TargetedOfferMessageComposer = 1245;
    public static final short CatalogueIndexMessageComposer = 36;
    public static final short CataloguePageMessageComposer = 1018;
    public static final short CatalogueClubPageMessageComposer = 435;
    public static final short CatalogOfferMessageComposer = 3126;
    public static final short CatalogueOfferConfigMessageComposer = 2234;
    public static final short PurchaseOKMessageComposer = 2950;
    public static final short CatalogPurchaseNotAllowedMessageComposer = 3140;
    public static final short CatalogLimitedItemSoldOutMessageComposer = 3373;
    public static final short SellablePetBreedsMessageComposer = 1086;
    public static final short ReloadEcotronMessageComposer = 3107;
    public static final short GiftWrappingConfigurationMessageComposer = 3357;
    public static final short RecyclerRewardsMessageComposer = 3476;
    public static final short CatalogPromotionGetRoomsMessageComposer = 2259;
    public static final short PublishShopMessageComposer = 3484;
    public static final short RecyclingStateMessageComposer = 3061;
    public static final short GiftErrorMessageComposer = 519;
    public static final short RetrieveSongIDMessageComposer = 1931;
    public static final short JukeboxNowPlayingMessageComposer = 1142;
    public static final short JukeboxPlaylistMessageComposer = 2286;
    public static final short SongsLibraryMessageComposer = 1416;
    public static final short SongsMessageComposer = 1030;
    public static final short VoucherErrorMessageComposer = 3804;
    public static final short VoucherValidMessageComposer = 3355;
    public static final short CatalogPromotionGetCategoriesMessageComposer = 2477;
    public static final short BuildersClubUpdateFurniCountMessageComposer = 3763;
    public static final short BuildersClubMembershipMessageComposer = 2920;
    public static final short LoadInventoryMessageComposer = 117;
    public static final short UpdateInventoryMessageComposer = 3757;
    public static final short EffectsInventoryMessageComposer = 689;
    public static final short NewInventoryObjectMessageComposer = 1773;
    public static final short RemoveInventoryObjectMessageComposer = 2692;
    public static final short LoadBadgesWidgetMessageComposer = 3294;
    public static final short BotInventoryMessageComposer = 200;
    public static final short PetInventoryMessageComposer = 3675;
    public static final short AddEffectToInventoryMessageComposer = 2206;
    public static final short ApplyEffectMessageComposer = 3256;
    public static final short EnableEffectMessageComposer = 956;
    public static final short StopAvatarEffectMessageComposer = 2554;
    public static final short InitialRoomInfoMessageComposer = 2075;//3415;
    public static final short PrepareRoomMessageComposer = 3447;
    public static final short HeightMapMessageComposer = 3806;//3677;
    public static final short FloorMapMessageComposer = 2401;//2759;
    public static final short HasOwnerRightsMessageComposer = 2599;
    public static final short UserDisplayMessageComposer = 504;//1321;
    public static final short UserStatusMessageComposer = 2627;//2463;
    public static final short RoomSpacesMessageComposer = 1735;//3139;
    public static final short RoomChatOptionsMessageComposer = 3635;
    public static final short RoomErrorMessageComposer = 1214;
    public static final short RoomDataMessageComposer = 893;
    public static final short RoomEnterErrorMessageComposer = 1675;//869;
    public static final short RoomEventMessageComposer = 3781;
    public static final short RoomFloorItemsMessageComposer = 2963;
    public static final short RoomFloorWallLevelsMessageComposer = 3236;
    public static final short RoomGroupMessageComposer = 3472;
    public static final short RoomOwnershipMessageComposer = 1025;
    public static final short RoomRatingMessageComposer = 2912;//1250;
    public static final short RoomRightsLevelMessageComposer = 2960; //may need to check this? //2437;
    public static final short LoadRoomRightsListMessageComposer = 1808;
    public static final short RoomBannedListMessageComposer = 3252;
    public static final short RoomSettingsDataMessageComposer = 2505;
    public static final short RoomLoadFilterMessageComposer = 3103;
    public static final short RoomSettingsSavedMessageComposer = 360;
    public static final short SendRoomCampaignFurnitureMessageComposer = 3060;
    public static final short RoomForwardMessageComposer = 1000;
    public static final short GroupRoomMessageComposer = 2973;
    public static final short OnCreateRoomInfoMessageComposer = 1037;
    public static final short RoomUpdateMessageComposer = 1091;//2306;
    public static final short RoomWallItemsMessageComposer = 2246;
    public static final short GenericDoorbellMessageComposer = 2057;
	public static final short GenericNoAnswerDoorbellMessageComposer = 1868;
    public static final short RoomMuteStatusMessageComposer = 3219;
    public static final short GetFloorPlanUsedCoordsMessageComposer = 2115;
    public static final short SetFloorPlanDoorMessageComposer = 1189;
    public static final short RoomsQueue = 1476;
    public static final short SpectatorModeMessageComposer = 162;
    public static final short RoomUserActionMessageComposer = 757;
    public static final short RoomUserIdleMessageComposer = 3985;
    public static final short HotelScreenMessageComposer = 3825;//12;
    public static final short ApplyHanditemMessageComposer = 3956;
    public static final short ChatMessageComposer = 273;//1470;
    public static final short ShoutMessageComposer = 2046;//727;
    public static final short WhisperMessageComposer = 693;
    public static final short TypingStatusMessageComposer = 2604;//4;
    public static final short DanceStatusMessageComposer = 1005;//1701;
    public static final short UpdateUserDataMessageComposer = 1676;
    public static final short UpdateUsernameMessageComposer = 3742;
    public static final short UserBadgesMessageComposer = 2848;
    public static final short UserLeftRoomMessageComposer = 3475;//184;
    public static final short UserTagsMessageComposer = 3898;
    public static final short RelationshipMessageComposer = 1709;
    public static final short FloodFilterMessageComposer = 626;//1326;
    public static final short NameChangedUpdatesMessageComposer = 3381;
    public static final short NotAcceptingRequestsMessageComposer = 1586;
    public static final short GiveRoomRightsMessageComposer = 3936;
    public static final short RemoveRightsMessageComposer = 3068;
    public static final short RoomUnbanUserMessageComposer = 3566;
    public static final short GiveRespectsMessageComposer = 1169;
    public static final short UpdateAvatarAspectMessageComposer = 2909;
    public static final short UserUpdateNameInRoomMessageComposer = 182;
    public static final short UserIsPlayingFreezeMessageComposer = 2478;
    public static final short UpdateFreezeLivesMessageComposer = 602;
    public static final short UpdateIgnoreStatusMessageComposer = 8;
    public static final short TradeAcceptMessageComposer = 3681;
    public static final short TradeCloseMessageComposer = 2352;
    public static final short TradeCompletedMessageComposer = 2380;
    public static final short TradeConfirmationMessageComposer = 2596;
    public static final short TradeStartMessageComposer = 1459;
    public static final short TradeUpdateMessageComposer = 364;
    public static final short AddFloorItemMessageComposer = 1706;
    public static final short AddWallItemMessageComposer = 2846;
    public static final short PickUpFloorItemMessageComposer = 559;
    public static final short PickUpWallItemMessageComposer = 1796;
    public static final short DimmerDataMessageComposer = 995;
    public static final short ItemAnimationMessageComposer = 318;
    public static final short UpdateFloorItemExtraDataMessageComposer = 3341;
    public static final short UpdateRoomItemMessageComposer = 520;
    public static final short UpdateRoomWallItemMessageComposer = 3504;
    public static final short UpdateFurniStackMapMessageComposer = 484;
    public static final short UpdateTileStackMagicHeight = 3607;
    public static final short LoadPostItMessageComposer = 2654;
    public static final short OpenGiftMessageComposer = 3451;
    public static final short YouTubeLoadPlaylistsMessageComposer = 2298;
    public static final short YouTubeLoadVideoMessageComposer = 1790;
    public static final short RemovePetFromInventoryComposer = 2358;
    public static final short WiredRewardAlertMessageComposer = 1650;
    public static final short WiredSaveSuccessComposer = 1820;
    public static final short WiredFurniConditionComposer = 381;
    public static final short WiredFurniTriggerComposer = 575;
    public static final short WiredTriggerMessageComposer = 3517;
    public static final short BotSpeechListMessageComposer = 1289;
    public static final short PetInfoMessageComposer = 3628;
    public static final short PetTrainerPanelMessageComposer = 1484;
    public static final short AddPetExperienceMessageComposer = 114;
    public static final short CheckPetNameMessageComposer = 498;
    public static final short SerializePetMessageComposer = 1995;
    public static final short RespectPetMessageComposer = 3989;
    public static final short PetRespectNotificationMessageComposer = 2621;
    public static final short NotifyNewPetLevelMessageComposer = 2951;
    public static final short SendMonsterplantIdMessageComposer = 2035;
    public static final short PetBreedErrorMessageComposer = 2120;
    public static final short PetBreedMessageComposer = 1094;
    public static final short PetBreedResultErrorMessageComposer = 2533;
    public static final short PetBreedResultMessageComposer = 760;
    public static final short PlacePetErrorMessageComposer = 2076;
    public static final short GeneralErrorHabboMessageComposer = 2964;
    public static final short LoadModerationToolMessageComposer = 434;
    public static final short ModerationActionResultMessageComposer = 2426;
    public static final short ModerationToolIssueChatlogMessageComposer = 3173;
    public static final short ModerationRoomToolMessageComposer = 2985;
    public static final short ModerationTicketResponseMessageComposer = 991;
    public static final short ModerationToolIssueMessageComposer = 493;
    public static final short ModerationToolRoomVisitsMessageComposer = 2020;
    public static final short ModerationToolUpdateIssueMessageComposer = 3080;
    public static final short ModerationToolUserChatlogMessageComposer = 855;
    public static final short ModerationToolUserToolMessageComposer = 1472;
    public static final short ModerationToolRoomChatlogMessageComposer = 1486;
    public static final short TicketUserAlert = 369;
    public static final short BroadcastNotifMessageComposer = 3598;
    public static final short AlertNotificationMessageComposer = 1440;
    public static final short MOTDNotificationMessageComposer = 1551;
    public static final short SuperNotificationMessageComposer = 1802;
    public static final short EpicPopupMessageComposer = 3261;
    public static final short CustomUserNotificationMessageComposer = 3258;
    public static final short UsersClassificationMessageComposer = 2410;
    public static final short OpenBullyReportMessageComposer = 2655;
    public static final short BullyReportSentMessageComposer = 3432;
    public static final short OpenHelpToolMessageComposer = 10;
    public static final short HelperToolConfigurationMessageComposer = 2782;
    public static final short OnGuideSessionStartedMessageComposer = 805;
    public static final short OnGuideSessionPartnerIsTypingMessageComposer = 3199;
    public static final short OnGuideSessionMsgMessageComposer = 3425;
    public static final short OnGuideSessionInvitedToGuideRoomMessageComposer = 2042;
    public static final short OnGuideSessionAttachedMessageComposer = 1559;
    public static final short OnGuideSessionDetachedMessageComposer = 3740;
    public static final short OnGuideSessionError = 51;
    public static final short SendAchievementsRequirementsMessageComposer = 1823;
    public static final short AchievementListMessageComposer = 3160;
    public static final short AchievementProgressMessageComposer = 2106;
    public static final short UnlockAchievementMessageComposer = 2343;
    public static final short QuestAbortedMessageComposer = 1645;
    public static final short QuestCompletedMessageComposer = 1690;
    public static final short QuestListMessageComposer = 2238;
    public static final short QuestStartedMessageComposer = 777;
    public static final short ActivityPointsNotificationMessageComposer = 3710;
    public static final short CitizenshipStatusMessageComposer = 265;
    public static final short TalentLevelUpMessageComposer = 234;
    public static final short TalentsTrackMessageComposer = 769;
    public static final short ChangeFavouriteGroupMessageComposer = 526;
    public static final short FavouriteGroupMessageComposer = 2300;
    public static final short GroupDataEditMessageComposer = 1174;
    public static final short GroupDataMessageComposer = 293;
    public static final short GroupFurniturePageMessageComposer = 1574;
    public static final short GroupMembersMessageComposer = 2340;
    public static final short GroupPurchasePageMessageComposer = 2649;
    public static final short GroupPurchasePartsMessageComposer = 82;
    public static final short GroupAreYouSureMessageComposer = 3694;
    public static final short GroupConfirmLeaveMessageComposer = 789;
    public static final short GroupRequestReloadMessageComposer = 1858;
    public static final short GroupForumListingsMessageComposer = 3157;
    public static final short GroupForumDataMessageComposer = 461;
    public static final short GroupForumThreadRootMessageComposer = 3141;
    public static final short GroupForumThreadUpdateMessageComposer = 803;
    public static final short GroupForumNewThreadMessageComposer = 1191;
    public static final short GroupForumNewResponseMessageComposer = 916;
    public static final short GroupForumReadThreadMessageComposer = 459;
    public static final short GroupDeletedMessageComposer = 588;
    public static final short GameCenterGamesListMessageComposer = 3263;
    public static final short GameCenterGameAchievementsMessageComposer = 1943;
    public static final short GameCenterLeaderboardMessageComposer = 1240;
    public static final short GameCenterLeaderboard2MessageComposer = 2107;
    public static final short GameCenterGamesLeftMessageComposer = 661;
    public static final short GameCenterPreviousWinnerMessageComposer = 3726;
    public static final short GameCenterProductsMessageComposer = 248;
    public static final short GameCenterAllAchievementsMessageComposer = 3458;
    public static final short GameCenterEnterInGameMessageComposer = 3867;
    public static final short GameCenterJoinGameQueueMessageComposer = 61;
    public static final short GameCenterLoadGameUrlMessageComposer = 2075;
    public static final short PollQuestionsMessageComposer = 2656;
    public static final short SuggestPollMessageComposer = 180;
    public static final short MatchingPollMessageComposer = 1319;
    public static final short MatchingPollAnsweredMessageComposer = 1087;
    public static final short MatchingPollResultMessageComposer = 466;
    public static final short EnableNotificationsMessageComposer = 820;
    public static final short NuxSuggestFreeGiftsMessageComposer = 77;
    public static final short NuxListGiftsMessageComposer = 524;
    public static final short LatencyTestResponseMessageComposer = 3846;
    public static final short PingMessageComposer = 3548;
    public static final short SetCameraPriceMessageComposer = 230;
    public static final short GenericErrorMessageComposer = 524;//1494;
    public static final short InternalLinkMessageComposer = 202;
    public static final short CameraStorageUrlMessageComposer = 2373;
    public static final short CameraPurchaseOk = 2275;
    public static final short ThumbnailSuccessMessageComposer = 365;
    public static final short BullyRequestOpenedMessageComposer = 538;
    public static final short BullyRequestChatlogsMessageComposer = 127;
    public static final short BullyRequestVotesMessageComposer = 1507;
    public static final short BullyRequestResultMessageComposer = 2980;
    public static final short AcceptUserInsideRoomMessageComposer = 875;//
    
    // messenger
	public static final short InitMessengerMessageComposer = 2925;//
	public static final short MessengerCategoriesMessageComposer = 249;//
    public static final short FollowFriendErrorMessageComposer = 3125;
    public static final short FriendRequestsMessageComposer = 2801;
    public static final short FriendUpdateMessageComposer = 3412;//2537;
	public static final short MessengerSearchMessageComposer = 2953;//3427;
	public static final short MessengerSendRequest = 2061;
}
