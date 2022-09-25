import {getArchiveCategories, getArchiveDetail, getArchives} from '@services/archive';
import {GetArchiveCategoriesParams, GetArchiveListParams, archiveActions} from '@store/slices/archive';
import {Dispatch} from 'redux';

export const handleGetArchives = (param: GetArchiveListParams) => async (dispatch: Dispatch) => {
    try {
        dispatch(archiveActions.getArchivesListRequest(param));
        const data = await getArchives(param);
        dispatch(archiveActions.getArchivesListSuccess(data));
    } catch (error) {
        // @ts-ignore
        dispatch(archiveActions.getArchivesListFailed(error.message));
    }
};

export const handleFooterArchives = (param: GetArchiveListParams) => async (dispatch: Dispatch) => {
    try {
        dispatch(archiveActions.getFooterArchivesRequest(param));
        const data = await getArchives(param);
        dispatch(archiveActions.getFooterArchivesSuccess(data));
    } catch (error) {
        // @ts-ignore
        dispatch(archiveActions.getFooterArchivesFailed(error.message));
    }
};

export const handleGetArchiveDetail = (id: number) => async (dispatch: Dispatch) => {
    try {
        dispatch(archiveActions.getArchiveDetailRequest());
        const { data } = await getArchiveDetail(id);
        dispatch(archiveActions.getArchiveDetailSuccess(data));
    } catch (error) {
        // @ts-ignore
        dispatch(archiveActions.getArchivesListFailed(error.message));
    }
};

export const handleArchiveCategories = (param?: GetArchiveCategoriesParams) => async (dispatch: Dispatch) => {
    try {
        dispatch(archiveActions.getArchiveCategoriesRequest());
        const data = await getArchiveCategories(param);
        dispatch(archiveActions.getArchiveCategoriesSuccess(data));
    } catch (error) {
        // @ts-ignore
        dispatch(archiveActions.getArchiveCategoriesFailed(error.message));
    }
};

export const handleGetTrendingArchives = (param: GetArchiveListParams) => async (dispatch: Dispatch) => {
    try {
        dispatch(archiveActions.getTrendingArchivesRequest());
        const data = await getArchives({ ...param, isTrending_like: true });
        dispatch(archiveActions.getTrendingArchivesSuccess(data));
    } catch (error) {
        // @ts-ignore
        dispatch(archiveActions.getTrendingArchivesFailed(error.message));
    }
};

export const handleGetDestinationArchives = (param: GetArchiveListParams) => async (dispatch: Dispatch) => {
    try {
        dispatch(archiveActions.getDestinationArchivesRequest());
        const data = await getArchives(param);
        dispatch(archiveActions.getDestinationArchivesSuccess(data));
    } catch (error) {
        // @ts-ignore
        dispatch(archiveActions.getDestinationArchivesFailed(error.message));
    }
};

export const handleGetGuideArchives = (param: GetArchiveListParams) => async (dispatch: Dispatch) => {
    try {
        dispatch(archiveActions.getGuideArchivesRequest());
        const data = await getArchives(param);
        dispatch(archiveActions.getGuideArchivesSuccess(data));
    } catch (error) {
        // @ts-ignore
        dispatch(archiveActions.getGuideArchivesFailed(error.message));
    }
};

export const handleGetLatestArchives = (param: GetArchiveListParams) => async (dispatch: Dispatch) => {
    try {
        dispatch(archiveActions.getLastestArchivesRequest());
        const data = await getArchives(param);
        dispatch(archiveActions.getLastestArchivesSuccess(data));
    } catch (error) {
        // @ts-ignore
        dispatch(archiveActions.getLastestArchivesFailed(error.message));
    }
};

export const handleGetRelatedArchives = (param: GetArchiveListParams) => async (dispatch: Dispatch) => {
    try {
        dispatch(archiveActions.getRelatedArchivesRequest());
        const data = await getArchives(param);
        dispatch(archiveActions.getRelatedArchivesSuccess(data));
    } catch (error) {
        // @ts-ignore
        dispatch(archiveActions.getRelatedtArchivesFailed(error.message));
    }
};
